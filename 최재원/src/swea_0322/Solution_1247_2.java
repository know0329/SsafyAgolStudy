package swea_0322;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution_1247_2 {
	static int T, N, result, temp;
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
			temp = 0;
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
			Comb(0, 0, work[0], work[1]);
			sb.append("#" + t + " " + result + "\n");
		}
		System.out.println(sb);
	}
	static void Comb(int depth, int start, int nowX, int nowY) {
		if(depth == N) {
			temp += Math.abs(home[0] - nowX) + Math.abs(home[1] - nowY);
			result = Math.min(result, temp);
			return;
		}
		for(int i=0; i<N; i++) {
			if(visited[i]) continue;
			else {
				visited[i] = true;
				temp += Math.abs(map.get(i)[0] - nowX) + Math.abs(map.get(i)[1] - nowY);
				Comb(depth+1, i+1, map.get(i)[0], map.get(i)[1]);
				visited[i] = false;
			}
		}
		
	}
}
