class Solution {
    public int solution(int n) {
        int[] fibo = new int[n + 1];
        fibo[0] = 0;
        fibo[1] = 1;
        for(int i = 2; i <= n; i++){
            fibo[i] = (fibo[i - 1] + fibo[i - 2]) % 1234567;
        }
        return fibo[n];
    }
}

/*
# LCS 길이 구하기(최장 공통 길이 수열)
class Solution {
    private static int solution(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }
}

# LIS 길이 구하기(최장 증가 부분 수열) => O(N^2)
import java.util.Arrays;

class Solution {
    private static int lis(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}

# LIS 길이 구하기(최장 증가 부분 수열) => O(NlogN): tails 배열에서 이분 탐색으로 위치 찾고 교체
class Solution {
    public static int lis(int[] nums) {
        int n = nums.length;
        if (n == 0) 
            return 0;

        int[] tails = new int[n]; // tails[i]: 길이 i+1인 증가 수열의 최소 끝값
        int size = 0;             // 현재까지 만들어진 수열 길이

        for (int x : nums) {
            // 1. tails[0..size) 구간에서 x가 들어갈 위치를 이분 탐색
            int left = 0;
            int right = size;

            while (left < right) {
                int mid = (left + right) / 2;
                if (tails[mid] < x) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            // 2. tails[left] 자리에 x를 놓는다.
            // left == size 이면, 새로운 길이 추가
            tails[left] = x;
            if (left == size) {
                size++;
            }
        }
        return size;
    }
}

# 조약돌 문제
class Solution {
    private static int solution(int[][] arr){
        int n = arr[0].length;
        int[][] dp = new int[4][n]; // 메모이제이션을 위한 2차원 배열
        
        dp[0][0] = arr[0][0]; // 상단
        dp[1][0] = arr[1][0]; // 중단
        dp[2][0] = arr[2][0]; // 하단
        dp[3][0] = arr[3][0]; // 상단 + 하단
        
        // 두번째 열부터 마지막 열까지 각 열에서 선택 가능한 4가지 배치패턴 마다 최대 가중치 계산
        for(int i = 1; i < n; i++){
            dp[0][i] = arr[0][i] + Math.max(dp[1][i - 1], dp[2][i - 1]);
            dp[1][i] = arr[1][i] + Math.max(dp[0][i - 1], Math.max(dp[2][i - 1], dp[3][i - 1]));
            dp[2][i] = arr[2][i] + Math.max(dp[0][i - 1], dp[1][i - 1]);
            dp[3][i] = arr[0][i] + arr[2][i] + dp[1][i - 1];
        }
        return Math.max(Math.max(dp[0][n - 1], dp[1][n - 1]), Math.max(dp[2][n - 1], dp[3][n - 1]));
    }
}
*/






