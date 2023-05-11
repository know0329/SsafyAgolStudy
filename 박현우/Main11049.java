package algorithm;

import java.io.*;
import java.util.*;

// https://yeeybook.tistory.com/127
public class Main11049 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, res;
	static int[][] dp;
	static int[][] gop;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());

		gop = new int[n][2];
		dp = new int[n][n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			gop[i][0] = Integer.parseInt(st.nextToken());
			gop[i][1] = Integer.parseInt(st.nextToken());
		}

		// (0~a) + (a+1 ~ n-1) + 0*a*n-1
		for(int step=1;step<n;step++) {
			for(int st=0;st+step<n;st++) {
				dp[st][st+step] = 987654321;
				// 0 ~ step step ~ n-1 까지를 세분화 0~1, 1~2, 2~3 .... , 0~2, 1~3, 2~4 ...
				for(int mid=st;mid<st+step;mid++) {
					dp[st][st+step] = Math.min(dp[st][st+step], dp[st][mid]+dp[mid+1][st+step]+gop[st][0]*gop[mid][1]*gop[st+step][1]);
				}
			}
		}
		
		System.out.println(dp[0][n-1]);
	}

}