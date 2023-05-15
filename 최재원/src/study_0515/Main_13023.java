package study_0515;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_13023 {
	
	static int N, M, result;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		result = 0;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
//		visited = new boolean[N];
		list = new ArrayList[N];
		for(int i=0; i<N; i++) 
			list[i] = new ArrayList<>();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int temp1 = Integer.parseInt(st.nextToken());
			int temp2 = Integer.parseInt(st.nextToken());
			// 양방향. a->b 친구이면 b->a 친구.
			list[temp1].add(temp2);
			list[temp2].add(temp1);
		}
		// dfs
		for(int i=0; i<N; i++) {
			// visited 방문 초기화.
			visited = new boolean[N];
			// result == 1이면 더이상 탐색 X.
			if(result == 1) break;
			else dfs(i,0);
		}
		System.out.println(result);
	}
	
	static void dfs(int idx, int depth) {
		// 깊이가 4가 될 수 있으면 결과 1 출력하고 종료.
		// dfs 호출이 4회 -> 5개 노드가 연속으로 존재한다는 뜻.
		if(depth == 4) {
			result = 1;
			return;
		}
		visited[idx] = true;
		// 현재 노드와 연결된 노드 탐색.
		for(int i=0; i<list[idx].size(); i++) {
			int temp = list[idx].get(i);
			if(visited[temp] == false) {
				visited[temp] = true;
				// depth를 +1 해주면서 해당 노드(temp)로 이동.
				dfs(temp, depth+1);
				visited[temp] = false;
			}
		}
	}
}
