package study_0316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15655 {
	static int N, M, before;
	static int[] arr;
	static int[] output;
	static StringBuilder sb = new StringBuilder();
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		visited = new boolean[N];
		output = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());  
		}
		
		Arrays.sort(arr);
		before = -1;
		comb(0,0);
		
		System.out.println(sb);
		
	}
	static void comb(int depth, int start) {
		if(depth == M) {
			for(int i=0; i<depth; i++) {
				sb.append(output[i]).append(" ");
			}
			sb.append("\n");
			depth = 0;
//			before = -1;
			return;
		}
		
		for(int i=start; i<N; i++) {
			if(visited[i] == true) continue;
//			if(before > arr[i]) continue;
			else {
				visited[i] = true; 
				output[depth] = arr[i];
//				before = output[depth];
				comb(depth+1, i);
				visited[i] = false;
			}
		}
	}
}
