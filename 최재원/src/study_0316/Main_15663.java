package study_0316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main_15663 {
	static int N, M;
	static int[] arr;
	static int[] before;
	static int[] output;
	static StringBuilder sb = new StringBuilder();
	static boolean[] visited;
	static LinkedHashSet<String> set;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		visited = new boolean[N];
		output = new int[M];
		set = new LinkedHashSet<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());  
		}
		
		Arrays.sort(arr);
//		before = -1;
		comb(0,0);
		
		System.out.println(sb);
//		System.out.println(set);
		
	}
	static void comb(int depth, int start) {
		if(depth == M) {
			String str = "";
			for(int i=0; i<depth; i++) {
				str += output[i];
				str += " ";
//				sb1.append(output[i]).append(" ");
			}
//			sb.append("\n");
			if(set.contains(str)) return;
			else {
				set.add(str);
				sb.append(str).append("\n");
			}
//			set.add(str);
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
				comb(depth+1, 0);
				visited[i] = false;
			}
		}
	}
}
