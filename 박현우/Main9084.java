package algorithm;

import java.io.*;
import java.util.*;

public class Main9084 {
	static int[] dp;
	static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int test_case = Integer.parseInt(st.nextToken());
		
		for(int t=0;t<test_case;t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) arr[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			dp = new int[m+1];
			dp[0] = 1;
			
			for(int i=0;i<arr.length;i++) {
				for(int j=arr[i];j<=m;j++) {
					dp[j] += dp[j - arr[i]];
				}
			}
				
			sb.append(dp[m]);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}