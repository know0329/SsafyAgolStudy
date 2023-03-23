package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CountOne {
	static long a,b; 
	static StringBuilder sb = new StringBuilder();
	static long[] dp = new long[54];
	static final int maximum = 54; // 10^16 은 54개의 비트로 나타낼 수 있음
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		a = Long.parseLong(st.nextToken());
		b = Long.parseLong(st.nextToken());
		
		for(int i=1;i<=53;i++)
			dp[i] = (long) (2*dp[i-1] + Math.pow(2,i-1));
		
		System.out.println(one(b) - one(a-1));
	}
	
	private static long one(long num) {
		long res = 0;
		long first = 1; // 상수 1을 32번 이상 비트시프트하면 오버플로우(음수) 비트가 됨
		int start = 0;
		// 1에서 시작하므로 3번시프트 하면 4번째 비트를 확인하는 거고 바로 -1번째인 dp[4-1]까지(i번째) 누적합을 더한다.
		for(int i = 53 ;i >= 0; i--) {
			if((num & (first<<i)) != 0) {
				if(start == 0) start = i+1; // 최초로 비트가 1인 곳을 표시
				res += dp[i];
				res += num-(long)(Math.pow(2,i)-1);
				// 최초로 비트가 1인 곳에서 최상위 비트갯수 더하기  ex) 12이라면 4개비트 사용되고 4개비트는 16까지 표현하므로 16-8이 아닌 12-8을 구해야함
				// 이후 체크한 비트 제거
				num = num - (first<<i); // 우선순위 주의! - 가 먼저됨
			}
		}

		return res;
	}
}

