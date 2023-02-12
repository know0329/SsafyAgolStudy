package Study_0213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class study_0213_15651 {
	static int N;
	static int M;
	static int[] arr;
	static StringBuffer result = new StringBuffer();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
//		N = sc.nextInt();
//		M = sc.nextInt();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];

		dfs(0);
		
		System.out.println(result);
	}
	
	public static void dfs(int depth) {
		if(depth < M) {
			for(int i=0; i<N; i++) {
				arr[depth] = i+1;
				dfs(depth+1);
			}
		}else {
			for(int i=0; i<arr.length; i++) {
				result.append(arr[i] + " ");
			}
			result.append("\n");
		}
	}
}