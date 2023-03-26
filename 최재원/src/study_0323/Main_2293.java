package study_0323;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2293 {
	static int N, K;
	static int[] coin, dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		coin = new int[N];
		dp = new int[K+1];
		Arrays.sort(coin);
		for(int n=0; n<N; n++) 
			coin[n] = Integer.parseInt(br.readLine());
		
		dp[0] = 1;
		// dp[k] = dp[k-coin[0]] + dp[k-coin[1]] + dp[k-coin[2]] + ... + dp[k-coin[n-1]] 
		// dp[3] = dp[3-coin[0]] + dp[3-coin[1]] = dp[2] + dp[1] = 2 + 1 = 3
		// (1,1,1), (1,2), (2,1)가 포함됨.	 중복.
		
		//dp[3](1원,2원짜리 동전으로 표현한 경우의 수) 
		// = dp[3](기존의 1원짜리 동전만으로 표현한 경우의 수) + dp[1](2원 추가)
		// 즉, j >= coin[i]일 때만 dp[] 값이 달라지게 됨.
		
		for (int i = 0; i < N; i++) {
			for (int j = 1; j <= K; j++) {
				if (j >= coin[i])
					dp[j] += dp[j - coin[i]];
			}
		}
		System.out.println(dp[K]);
	}
}
