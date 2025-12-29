import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        long[] sum = new long[N];
        long[] count = new long[M];
        long answer = 0;
        sum[0] = sc.nextInt();
        for(int i = 1; i < N; i++) {
            sum[i] = sum[i - 1] + sc.nextInt();
        }
        for(int i = 0; i < N; i++){
            int remainder = (int) (sum[i] % M);
            if(remainder == 0) answer++;
            count[remainder]++;
        }
        for(int i = 0; i < M; i++){
            if(count[i] > 1){
                answer += count[i] * (count[i] - 1) / 2;
            }
        }
        System.out.println(answer);
    }
}
