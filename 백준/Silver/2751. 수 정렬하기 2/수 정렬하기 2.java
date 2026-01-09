import java.io.*;

public class Main {
    private static int[] A, tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        tmp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        mergeSort(1, N);
        for (int i = 1; i <= N; i++) {
            bw.write(A[i] + "\n");
        }
        bw.flush();
    }

    private static void mergeSort(int start, int end) {
        if (end - start < 1) { // 구간 길이가 1인 상태
            return;
        }
        int mid = start + (end - start) / 2; // Divide&Conquer(분할정복)의 기본 문법이다.
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