package study_0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15657_NM8 {
	static int N, M;
	static int[] arr, out;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		out = new int[N];
		Comb(0,0);
		
	}
	static void Comb(int start, int depth) {
		if(depth == M) {
			for(int i=0; i<depth; i++) {
				System.out.print(out[i] + " ");
			}
			System.out.println();
//			out = new int[N];
			return;
		}
//		visited[start] = true;
		for(int i=start; i<N; i++) {
//			if(visited[i] == true) continue;
			visited[i] = true;
			out[depth] = arr[i];
			// i+1이 아닌, i로. (같은 값을 출력 받기 위해)
			Comb(i, depth+1);
			visited[i] = false;
		}
		
	}
}
