package swea_0322;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution_1247 {
	static int T, N, result;
	static HashMap<Integer, int[]> map;
	static int[] home, work, route;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new HashMap<Integer, int[]>();
			visited = new boolean[N];
			route = new int[N];
			result = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<2; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				if(i==0) work = new int[] {x, y};
				if(i==1) home = new int[] {x, y};
			}
			for(Integer i=0; i<N; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map.put(i, new int[] {x, y});
			}
//			System.out.println(Arrays.toString(work));
//			System.out.println(Arrays.toString(home));
//			map.forEach((key, value) -> {
//				System.out.println(key + " : " + Arrays.toString(value));
//			});
			
			Comb(0,0);
			sb.append("#" + t + " " + result + "\n");
		}
		System.out.println(sb);
	}
	static void Comb(int depth, int start) {
		if(depth == N) {
//			System.out.println(Arrays.toString(route));
			// route 배열 값 순서대로 판매 방문.
			int x = work[0];
			int y = work[1];
			int totalDistance = 0;
			for(int i=0; i<route.length; i++) {
				int nx = map.get(route[i])[0];
				int ny = map.get(route[i])[1];
				totalDistance += Math.abs(x-nx) + Math.abs(y-ny);
				x = nx;
				y = ny;
			}
			totalDistance += Math.abs(x-home[0]) + Math.abs(y-home[1]);
			result = Math.min(result, totalDistance);
			return;
		}
		for(int i=0; i<N; i++) {
			if(visited[i]) continue;
			else {
				visited[i] = true;
				route[i] = depth;
				Comb(depth+1, i+1);
				visited[i] = false;
			}
		}
		
	}
}
