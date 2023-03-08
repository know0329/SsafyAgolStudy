package study_0302;

import java.util.Scanner;

public class Main_9095 {
	
	static int T, N, cnt;
	static int[] dp = new int[11];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		dp[0] = 0; 
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int t=0; t<T; t++) {
			cnt = 0;
			N = sc.nextInt();
			
			for(int i=4; i<=N; i++) {
				dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
			}
			
			sb.append(dp[N]).append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
}
