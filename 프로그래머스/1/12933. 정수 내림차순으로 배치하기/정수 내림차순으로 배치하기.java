import java.util.Arrays;
import java.util.Collections;

class Solution {
    public long solution(long n) {
        String str = String.valueOf(n);
        Character[] arr = new Character[str.length()];
        
        for(int i = 0; i < str.length(); i++){
            arr[i] = str.charAt(i);
        }
        
        Arrays.sort(arr, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for(char  c : arr){
            sb.append(c);
        }
        return Long.parseLong(sb.toString());
    }
}