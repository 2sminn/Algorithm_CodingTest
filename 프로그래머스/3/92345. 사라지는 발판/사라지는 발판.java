import java.util.ArrayList;
import java.util.Comparator;

class Solution {
    private static class Result{
        boolean win;
        int step;
        
        public Result(boolean win, int step){
            this.win = win;
            this.step = step;
        }
    }
    
    private static final int[] dr = {0,-1,0,1};
    private static final int[] dc = {-1,0,1,0};
    private static int[][] Board;
    private static boolean[][] visited;    
    private static int ROW, COL;
    
    private static boolean isValidPos(int r, int c){
        return r >= 0 && c >= 0 && r < ROW && c < COL;
    }
    
    private static Result recursive(int[] alpha, int[] beta, int step){
        int[] now = step % 2 == 0 ? alpha : beta;
        boolean canMove = false;
        boolean isOpponentWin = true;
        
        ArrayList<Integer> winStep = new ArrayList<>();
        ArrayList<Integer> loseStep = new ArrayList<>();
        
        for(int i = 0; i < 4; i++){
            int nr = now[0] + dr[i];
            int nc = now[1] + dc[i];
            
            if(isValidPos(nr, nc) && !visited[nr][nc] && Board[nr][nc] == 1){
                canMove = true;
                if(alpha[0] == beta[0] && alpha[1] == beta[1]){
                    return new Result(true, step+1); //A가 이기는 경우. 즉, 먼저 시작한 살람이 이김.
                }
                visited[now[0]][now[1]] = true;
                Result result = step % 2 == 0 ? recursive(new int[]{nr,nc}, beta, step+1) : recursive(alpha, new int[]{nr,nc}, step+1);
                visited[now[0]][now[1]] = false;
                
                isOpponentWin &= result.win;
                if(result.win){
                    winStep.add(result.step);
                } else{
                    loseStep.add(result.step);
                }
            }
        }
        
        if(!canMove)
            return new Result(false, step);
        if(isOpponentWin)
            return new Result(false, winStep.stream().max(Comparator.comparingInt(o->o)).get());
        return new Result(true, loseStep.stream().min(Comparator.comparingInt(o->o)).get());
    }
    
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        Board = board;
        ROW = board.length;
        COL = board[0].length;
        visited = new boolean[ROW][COL];
        return recursive(aloc,bloc,0).step;
    }
}