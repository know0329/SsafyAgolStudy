import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B15655 {
    static int N;
    static int M;
    static int[] arr;
    static int[] choice;
    static StringBuilder sb;
    static void rec(int count, int index){
        if(count == M){
            for (int i=0; i < M; i++){
                sb.append(choice[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = index; i < N; i++){
            choice[count] = arr[i];
            rec(count+1, i+1);

        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        arr = new int[N];
        choice = new int [M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        rec(0, 0);
        System.out.println(sb.toString());
    }
}
