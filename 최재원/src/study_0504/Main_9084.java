package study_0504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9084 {
	static int T, N, money, result;
	static int[] arr, dp;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=0; t<T; t++) {
			// 입력
			N = Integer.parseInt(br.readLine());
			arr = new int[N+1];
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<N+1; i++) 
				arr[i] = Integer.parseInt(st.nextToken());
			money = Integer.parseInt(br.readLine());
			
			// 풀이
			// 2원짜리 동전으로 1원 -> 1원
			// 2원짜리 동전으로 2원 -> 0원 + 2원
			// 2원짜리 동전으로 3원 -> 1원 + 2원 -> dp[3] = dp[1]
			// 2원짜리 동전으로 4원 -> 2원 + 2원 -> dp[4] = dp[2]
			// 2원짜리 동전으로 5원 -> 3원 + 2원 -> dp[5] = dp[3]
			dp = new int[money+1];
			dp[0] = 1;
			for(int i=1; i<N+1; i++) {
				int coin = arr[i];
				
				for(int j=coin; j<=money; j++) 
					dp[j] += dp[j-coin];
			
			}
			sb.append(dp[money]).append("\n");
		}
		System.out.println(sb);
	}
}
