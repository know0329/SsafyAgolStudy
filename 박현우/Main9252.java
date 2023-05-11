package algorithm;

import java.io.*;
import java.util.*;

//https://velog.io/@emplam27/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EA%B7%B8%EB%A6%BC%EC%9C%BC%EB%A1%9C-%EC%95%8C%EC%95%84%EB%B3%B4%EB%8A%94-LCS-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-Longest-Common-Substring%EC%99%80-Longest-Common-Subsequence
public class Main9252 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] dp;
	static String a, b;

	public static void main(String[] args) throws IOException {
		a = br.readLine();
		b = br.readLine();

		int alen = a.length();
		int blen = b.length();

		dp = new int[alen + 1][blen + 1];

		for (int i = 1; i <= alen; i++) {
			for (int j = 1; j <= blen; j++) {
				if (a.charAt(i - 1) != b.charAt(j - 1))
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				else
					dp[i][j] = dp[i - 1][j - 1] + 1;
			}
		}

		int cur = dp[alen][blen];
		int i = alen;
		int j = blen;
		StringBuffer res = new StringBuffer();
		
		while(dp[i][j] != 0) {
			if (dp[i-1][j] == cur) {
				i--;
			} else if (dp[i][j-1] == cur) {
				j--;
			} else {
				res.append(a.charAt(i - 1));
				i --;
				j --;
				cur--;
			}
		}

		System.out.println(dp[alen][blen]);
		System.out.println(res.reverse());
	}

}