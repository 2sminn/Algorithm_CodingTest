import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static int[] A, tmp;
    private static long result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        tmp = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        result = 0;
        mergeSort(1, N);
        System.out.println(result);
    }

    private static void mergeSort(int start, int end) {
        if (end - start < 1) {
            return;
        }
        int mid = start + (end - start) / 2; 
        mergeSort(start, mid);
        mergeSort(mid + 1, end);
        for (int i = start; i <= end; i++) {
            tmp[i] = A[i];
        }
        int k = start;
        int index1 = start;
        int index2 = mid + 1;
        while (index1 <= mid && index2 <= end) {
            if (tmp[index1] > tmp[index2]) {
                A[k] = tmp[index2];
                result += index2 - k;
                k++;
                index2++;
            } else {
                A[k] = tmp[index1];
                k++;
                index1++;
            }
        }
        while (index1 <= mid) {
            A[k] = tmp[index1];
            k++;
            index1++;
        }
        while (index2 <= end) {
            A[k] = tmp[index2];
            k++;
            index2++;
        }
    }
}