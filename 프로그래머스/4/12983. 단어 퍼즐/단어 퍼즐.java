import java.util.HashSet;
import java.util.Arrays;

class Solution {
    private static final int INF = 20_001;
    
    public int solution(String[] strs, String t) {
        int n =  t.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        
        HashSet<String> dict = new HashSet<>(Arrays.asList(strs));
        
        for(int i = 1; i <= n; i++){
            for(int len = 1; len <= 5; len++){
                if(i - len < 0) continue;
                if(dp[i - len] == INF) continue;
                String sub = t.substring(i - len, i);
                if(dict.contains(sub)){
                    dp[i] = Math.min(dp[i], dp[i - len] + 1);
                }
            }
        }
        return dp[n] < INF ? dp[n] : -1;
    }
}