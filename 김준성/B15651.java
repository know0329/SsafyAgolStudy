import java.util.*;
import java.io.*;
public class B15651 {

    static int [] selected;
    static StringBuilder sb;
    static void recFunc(int count, int[] numArr){
        if(count == M){
            for(int i = 0; i < M; i++){ sb.append(selected[i]).append(' ');}
            sb.append('\n');
            return;
        }
        else {
            for (int i = 0; i < N; i++) {
                // 선택한 숫자를 넣어줌
                selected[count] = numArr[i];
                recFunc(count + 1, numArr);
            }
        }
    }
    static int N;
    static int M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        sb = new StringBuilder();
        int [] numArr = new int[N];
        selected = new int[M];
        // 해당하는 숫자를 배열에 집어넣음 => 근데 숫자를 뽑는거라 그냥 for문의 index값을 사용해도 상관이 없다.
        for (int i = 1; i <= N; i++){
            numArr[i-1] = i;
        }

        recFunc(0, numArr);
        System.out.println(sb.toString());
    }

}
