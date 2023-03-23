package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Coin1 {
	static int n,k,res; 
	static Integer[] possible;
	static int[] dp = new int[10001];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
			
		possible = new Integer[n];
		int cnt = 0;
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int coin = Integer.parseInt(st.nextToken());
			if(coin <= k) possible[cnt++] = coin;
		}
		
		//Arrays.sort(possible);// 범위는 n 인데 cnt만 사용해버려서 에러뜸
		Arrays.sort(possible,0,cnt);
		
		// k보다 가치 높은 동전은 버린다.
		n = cnt;
		dp[0] = 1; // 자기자신 dp[2] = 1+dp[1] & 2+dp[0]
		
		// dp = 자기보다 작은 금액을 가지고 있는 동전 액수를 빼고 남은 부분에 대한 dp 연산
		// 아이디어는 맞았는데 구현을 dfs로 이상하게 한듯. 답지 참조
		for(int i=0;i<n;i++) {
			for(int j=possible[i];j<=k;j++) {
				dp[j] += dp[j-possible[i]];
			}
		}
		
		res = dp[k];
		
		System.out.println(res);
	}
}
