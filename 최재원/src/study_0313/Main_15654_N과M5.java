package study_0313;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15654_N과M5 {
	
	static int N, M;
	static int[] input;
	static int[] output;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new int[N];
		output = new int[N];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		if(M == 1) {
			for(int i=0; i<N; i++) {
				sb.append(input[i]).append("\n");
			}
		}else {
			Comb(0);
		}
		System.out.println(sb);
	}
	
	static void Comb(int depth) {
		if(depth == M) {
			for(int i=0; i<M; i++) {
				sb.append(output[i]).append(" ");
			}
			sb.append("\n");
		}
		
		for(int i=0; i<N; i++) {
			if(visited[i] == true) continue;
			else {
				visited[i] = true;
				output[depth] = input[i];
				Comb(depth+1);
				visited[i] = false;
			}
			visited[i] = false;
		}
//		for(int i=0; i<N; i++) {
//			visited[i] = true;
//			for(int j=start; j<N; j++) {
//				if(visited[j] == true) continue;
//				else {
//					visited[j] = true;
//					Comb(depth+1, start+1);
//					visited[j] = false;
//				}
//			}
//			visited[i] = false;
//		}
	}
}
