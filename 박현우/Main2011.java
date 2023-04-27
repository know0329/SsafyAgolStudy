package algorithm;

import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main2011 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int res;
	static String n;
	static int[] dp = new int[5001];
	static final int bot = 1_000_000;

	public static void main(String[] args) throws IOException {
		n = br.readLine();

		int loop = n.length();
		// 시작이 0이거나, 1자리 문자열이 0 이거나, 시작이 빈 입력인 경우 결과는 해석불가능(0)
		if (n.charAt(0) == '0' || loop <= 0) {
			System.out.println(0);
			return;
		}
		
		dp[0] = dp[1] = 1; // 글자 1개일때는 0만 아니면 무조건 해석가능 1~9
		// '현재위치' 글자 하나만으로 해석가능한지 (중간에 '20' 같은경우 0을 해석할 수 없음) & 앞에있는 글자와 합쳐 해석가능한지
		// 27이상부터는 해석불가
		for (int i = 2; i <= loop; i++) {
			int temp = 0;
			if (n.charAt(i - 1) != '0') temp += (dp[i - 1]%bot); // 글자수가 i일 때 시작점은 i-1위치
			//parseInt("01")의 결과가 1이 나오므로 가능한 해석으로 처리됨 -> 체크필요
			int two = Integer.parseInt(n.substring(i - 2, i));
			if (two >= 10 && two <= 26) temp += (dp[i - 2])%bot;
			dp[i] = temp % bot;
		}

		System.out.println(dp[loop] % bot);
	}
}