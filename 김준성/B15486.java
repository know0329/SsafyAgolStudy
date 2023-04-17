import java.util.*;
import java.io.*;
public class B15486 {
    static int N;
    static int [][] arr;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        arr = new int[N][2];
        for(int i = 0; i < N; i++){
            stk = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(stk.nextToken());
            arr[i][1] = Integer.parseInt(stk.nextToken());
        }
        int [] dp = new int [N+1];
        for(int i = 0; i < N; i++){
            if(i+arr[i][0] <= N){
                dp[i+arr[i][0]] = Math.max(dp[i+arr[i][0]], dp[i]+arr[i][1]); // 상담 실행
            }
            dp[i+1] = Math.max(dp[i+1], dp[i]); // 상담 시행 안함
        }
        System.out.println(dp[N]);
    }
}