package algorithm;

import java.io.*;
import java.util.*;

public class Nojob {
	static int[][] counsel;
	static int[] dp;
	static int n, res;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		
		dp = new int[n+1];
		counsel = new int[n][2];
		
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			counsel[i][0] = Integer.parseInt(st.nextToken());
			counsel[i][1] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = 0;
		
		// setting
		for(int i=0;i<n;i++) {
			int next = i + counsel[i][0];
			if(next > n) continue;
			dp[next] = Math.max(dp[next], counsel[i][1]);
		}			
		
		//for(int i=0;i<=n;i++) System.out.print(dp[i] + " ");
		//System.out.println();
		
		for(int i=0;i<n;i++) {
			if(i != 0) dp[i] = Math.max(dp[i], dp[i-1]);
			int next = i + counsel[i][0];
			if(next > n) continue;
			dp[next] = Math.max(dp[next], dp[i] + counsel[i][1]);			
		}
		
		dp[n] = Math.max(dp[n],dp[n-1]);
		
		// for(int i=0;i<=n;i++) System.out.print(dp[i] + " ");
		System.out.println(dp[n]);
	}
}

