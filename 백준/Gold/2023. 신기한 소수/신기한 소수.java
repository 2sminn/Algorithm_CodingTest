import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);
    }
    private static void dfs(int number, int digits) {
        if (digits == N) {
            System.out.println(number);
            return;
        }
        for (int i = 1; i < 10; i += 2) {
            int next = number * 10 + i;
            if (isPrime(next)) {
                dfs(next, digits + 1);
            }
        }
    }
    private static boolean isPrime(int k) {
        if(k < 2) return false;
        for(int i = 2; i * i <= k; i++){
            if(k % i == 0) return false;
        }
        return true;
    }
}