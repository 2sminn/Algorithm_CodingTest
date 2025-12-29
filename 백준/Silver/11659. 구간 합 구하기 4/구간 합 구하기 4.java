import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int suNo = Integer.parseInt(st.nextToken());
        int quizNo = Integer.parseInt(st.nextToken());

        long[] Sum = new long[suNo + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= suNo; i++){
            Sum[i] = Sum[i - 1] + Integer.parseInt(st.nextToken());
        }
         // StringBuilder sb = new StringBuilder();
        for(int q = 0; q < quizNo; q++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
             // sb.append(Sum[j] - Sum[i - 1]).append('\n');
            System.out.println(Sum[j] - Sum[i - 1]);
        }
    }
}