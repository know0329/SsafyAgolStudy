package study_0406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1182 {
	static int N, S, result;
	static int[] arr;
	static int[] output = new int[N];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		result = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dfs(0,0);
		System.out.println(result-1);
	}
	
	static void dfs(int depth, int sum) {
		if(depth == N) {
			if(sum == S)
				result++;
			return;
		}
		dfs(depth+1, sum + arr[depth]);
		dfs(depth+1, sum);
	}
}
