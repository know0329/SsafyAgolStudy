package study_0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class dfs_bfs_1260 {
	static int N, M, V;
	static int[][] arr;
	static boolean[] visited;
	static Deque<Integer> q = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		arr = new int[N+1][N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			arr[from][to] = arr[to][from] = 1;
		}
		
		visited = new boolean[N+1];
		dfs(V);
		sb.append("\n");
		
		visited = new boolean[N+1];
		bfs(V);
		System.out.println(sb);
	}
	
	static void dfs(int v) {
		visited[v] = true;
		sb.append(v + " ");
		for(int i=0; i<=N; i++) {
			if(visited[i] == true) continue;
			if(arr[v][i] == 1) dfs(i);
		}
	}
	static void bfs(int v) {
		q.add(v);
		visited[v] = true;
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			sb.append(temp + " ");
			
			for(int i=1; i<=N; i++) {
				if(visited[i] == true) continue;
				if(arr[temp][i] == 1) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
	}
}
