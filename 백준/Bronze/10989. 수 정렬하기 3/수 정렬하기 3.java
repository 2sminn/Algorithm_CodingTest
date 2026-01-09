import java.io.*;

public class Main {
    private static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }
        radixSort(A, 5);
        for(int i = 0; i < N; i++){
            bw.write(A[i] + "\n");
        }
        bw.flush();
    }
    private static void radixSort(int[] A, int maxSize) {
        int[] output = new int[A.length];
        int jarisu = 1;
        int count = 0;
        while(count != maxSize){
            int[] bucket = new int[10]; // 0~9중에 하나
            for(int i = 0; i < A.length; i++){
                int d = A[i] / jarisu % 10;
                bucket[d]++;
            }
            for(int d = 1; d < 10; d++){ // 누적합해서 각 digit의 마지막위치 계산
                bucket[d] += bucket[d - 1];
            }
            // 큐에 삽입하고 빼는 과정을 output이라는 연속된 배열로 표현: digit 0,1,2,3..그룹별로 연속 구간으로 배치해야 해서 누적합 사용하고 (끝+1) 값 저장.
            for(int i = A.length - 1; i >= 0; i--){
                int d = A[i] / jarisu % 10;
                output[bucket[d] - 1] = A[i]; // = output[bucket[d] - 1]
                bucket[d]--;
            }

            for(int i = 0; i < A.length; i++){
                A[i] = output[i];
            }
            jarisu *= 10;
            count++;
        }
    }
}