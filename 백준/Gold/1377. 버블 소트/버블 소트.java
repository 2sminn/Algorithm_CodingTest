import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Mdata[] A = new Mdata[N];
        for(int i = 0; i < N; i++){
            A[i] = new Mdata(Integer.parseInt(br.readLine()), i);
        }
        Arrays.sort(A); // 정렬 끝남
        int MAX = 0;
        for(int i = 0; i < N; i++){
            if(MAX < A[i].index - i) { // 정렬전위치(인덱스) - 정렬후위치(인덱스)
                MAX = A[i].index - i; // 왼쪽으로 이동한 칸 수의 최댓값
            }
        }
        System.out.println(MAX + 1);
    }
}
class Mdata implements Comparable<Mdata>{
    int value;
    int index;
    public Mdata(int value, int index){
        super();
        this.value = value;
        this.index = index;
    }
    public int compareTo(Mdata o){ // value기준 오름차순 정렬
        return Integer.compare(this.value, o.value);
    }
}