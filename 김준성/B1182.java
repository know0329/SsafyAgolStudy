import java.util.*;
import java.io.*;
public class B1182 {
    static int N;
    static int S;
    static int [] arr;
    static int result;
    static boolean[] visited;
    static void rec(int count, int sum){
        if(count == N){
            if(sum == S) {
                result++;
            }
            return;
        }
        else {
            rec(count + 1, sum + arr[count]);
            rec(count + 1, sum);
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        S = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(br.readLine());
        arr = new int[N];
        visited = new boolean[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        rec(0, 0);
        if(S == 0)
            result--;
        System.out.println(result);
    }
}