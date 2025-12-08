class Solution {
    public int[] solution(String s) {
        int countTransform = 0;
        int countZero = 0;
        
        while(!s.equals("1")){
            countTransform++;
            int zero = s.replace("1", "").length();
            countZero += zero;
            s = Integer.toBinaryString(s.length() - zero);
        }
        return new int[]{countTransform, countZero};
    }
}

/*
# 2차원배열[][]을 시계방향 90도 회전
class Solution {
    private static int[][] rotate90(int [][] arr){
        int n = arr.length;
        int[][] rotatedArr = new int[n][n];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                rotatedArr[j][n-1-i] = arr[i][j];
            }
        }
        return rotatedArr;
    }
    
    private static int[][] solution(int[][] arr, int n){
        n = n % 4;
        for(int i = 0; i < n; i++){
            arr = rotate90(arr);
        }
    }
    return arr;
}

# 2차원 배열 행렬곱하고 전치행렬 하기.
class Solution {
    private static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2){
        int[][] result = new int[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                for(int k = 0; k < 3; k++){
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }
    
    private static int[][] transposeMatrices(int[][] matrix){
        int[][] result = new int[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }
    
    private static int[][] solution(int[][] matrix1, int[][] matrix2){
        int[][] multiplied = multiplyMatrices(matrix1, matrix2);
        int[][] transposed = transposeMatrices(multiplied);
        return transposed;
    }
}

# 시계 90도 회전: 전치->각 행 뒤집기, 반시계 90도 회전: 전치->각 열 뒤집기 
1. 전치
for (int i = 0; i < N; i++) {
    for (int j = i + 1; j < N; j++) {
        int tmp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = tmp;
    }
}

2. 각 행 뒤집기
for (int i = 0; i < N; i++) {
    for (int j = 0; j < N / 2; j++) {
        int tmp = arr[i][j];
        arr[i][j] = arr[i][N - 1 - j];
        arr[i][N - 1 - j] = tmp;
    }
}

# 깊은 복사 vs 얕은 복사(2차원 배열)
int[][] copy = new int[n][m];
for (int i = 0; i < n; i++) {
    System.arraycopy(original[i], 0, copy[i], 0, m);
}

# Prefix Sum(누적합) & 구간합 => 사각형에서 위쪽 전체 ps[i-1][j] + 왼쪽 전체 ps[i][j-1] - 왼쪽 위 겹치는 영역 ps[i-1][j-1] + 현재 칸 값 더하기 arr[i-1][j-1] = 전체 사각형

int[][] ps = new int[n+1][m+1];

for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= m; j++) {
        ps[i][j] = ps[i-1][j] + ps[i][j-1] - ps[i-1][j-1] + arr[i-1][j-1];
    }
}

// (x1, y1) ~ (x2, y2) 구간 합: 전체 - 위쪽 - 왼쪽 + 왼쪽 위 겹친 영역 => 포함-배제(중복제거원리)
int sum = ps[x2][y2] - ps[x1-1][y2] - ps[x2][y1-1] + ps[x1-1][y1-1];

# 달팽이 수열 만들기
class Solution {
    private static int[][] solution(int n) {
        int[][] snailArray = new int[n][n];
        int num = 1;
        int startRow = 0, endRow = n - 1;
        int startCol = 0, endCol = n - 1;
        
        while(startRow <= endRow && startCol <= endCol){
            // 첫번째 행 채우기
            for(int i = startCol; i <= endCol; i++){
                snailArray[startRow][i] = num++;
            }
            startRow++;
            
            // 마지막 열 채우기
            for(int i = startRow; i <= endRow; i++){
                snailArray[i][endCol] = num++;
            }
            endCol--;
            
            // 마지막 행 채우기
            if(startRow <= endRow){
                for(int i = endCol; i >= startCol; i--){
                    snailArray[endRow][i] = num++;
                }
                endRow--;
            }
            
            // 첫번째 열 채우기
            if(startCol <= endCol){
                for(int i = endRow; i >= startRow; i--){
                    snailArray[i][startCol] = num++;
                }
                startCol++;
            } 
        }
        return snailArray;
    }
}
*/