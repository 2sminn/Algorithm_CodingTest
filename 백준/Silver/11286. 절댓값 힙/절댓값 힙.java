import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int absA = Math.abs(o1);
            int absB = Math.abs(o2);
            if (absA != absB) {
                return Integer.compare(absA, absB); // 절댓값
            } else {
                return Integer.compare(o1, o2); // 실제 값
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                sb.append(pq.isEmpty() ? 0 : pq.poll()).append('\n');
            } else{
                pq.add(x);
            }
        }
        System.out.println(sb);
    }
}