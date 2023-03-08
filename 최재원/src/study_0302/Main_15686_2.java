package study_0302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15686_2 {
	
	static int N, M, result;
	static int[][] input;
	static ArrayList<int[]> home = new ArrayList<>();
	static ArrayList<int[]> chicken = new ArrayList<>();
	static boolean[] visit;
	static ArrayList<int[]> survive = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		input = new int[N][N];
		result = Integer.MAX_VALUE;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
				if(input[i][j] == 1)
					home.add(new int[] {i, j});
				if(input[i][j] == 2)
					chicken.add(new int[] {i,j});
			}
		}
		
		visit = new boolean[chicken.size()];
		
		calc(0,0);
		System.out.println(result);
	}
	
	static void calc(int start, int depth) {
		
		if(depth == M) {
			int sum = 0;
			for(int[] h : home) {
				int min = Integer.MAX_VALUE;
				for(int[] s : survive) {
					int dist = Math.abs(h[0] - s[0]) + Math.abs(h[1] - s[1]);
					min = Math.min(dist, min);
				}
				sum += min;
			}
			result = Math.min(result, sum);
			return;
		}
		
		for(int i=start; i<chicken.size(); i++) {
			
			if(visit[i] == true) continue;
			
			visit[i] = true;
			survive.add(chicken.get(i));
			calc(i+1, depth+1);
			survive.remove(survive.size()-1);
			visit[i] = false;
			
		}
		
	}
}
