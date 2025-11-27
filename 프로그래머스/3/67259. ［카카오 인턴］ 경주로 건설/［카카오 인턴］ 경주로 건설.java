import java.util.ArrayDeque;

class Solution {
    
    private static class Node{
        int x, y, direction, cost;
        public Node(int x, int y, int direction, int cost){
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.cost = cost;
        }
    }
    
    private static final int[] dx = {0,-1,0,1};
    private static final int[] dy = {-1,0,1,0};
    private static int N;
    private static int[][][] visited;
    
    private static boolean isValid(int x, int y){
        return x >= 0 && y >= 0 && x < N && y < N;
    }
    
    private static boolean isBlocked(int[][] board, int x, int y){
        return (x == 0 && y == 0) || !isValid(x,y) || board[x][y] == 1;
    }
    
    private static int calculateCost(int direction, int prevDirection, int cost){
        if(prevDirection == -1 || (prevDirection -direction) % 2 == 0){
            return cost + 100;
        } else {
            return cost + 600;
        }
    }
    
    private static boolean isShouldUpdate(int x, int y, int direction, int newCost){
        return visited[x][y][direction] == 0 || visited[x][y][direction] > newCost;
    }
    
    public int solution(int[][] board) {
    ArrayDeque<Node> queue = new ArrayDeque<>();
    queue.add(new Node(0,0,-1,0));
    N = board.length;
    visited = new int[N][N][4];
    
    int answer = Integer.MAX_VALUE;

    while(!queue.isEmpty()){
        Node now = queue.poll();
        
        for(int i = 0; i < 4; i++){
            int new_x = now.x + dx[i];
            int new_y = now.y + dy[i];
            
            if(isBlocked(board, new_x ,new_y)){
                continue;
            }
            
            int newCost = calculateCost(i, now.direction, now.cost);
            
            if(new_x == N-1 && new_y == N-1){
                answer = Math.min(answer, newCost);
            } else if(isShouldUpdate(new_x, new_y, i, newCost)){
                queue.add(new Node(new_x, new_y, i, newCost));
                visited[new_x][new_y][i] = newCost;
            }
        }
    }
    return answer;
    }
}