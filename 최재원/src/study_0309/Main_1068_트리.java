package study_0309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1068_트리 {
	
	static int N, D, root, cnt;
	static int[] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		visited = new boolean[N];
		cnt = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n=0; n<N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
			if(arr[n] == -1) root = n;
		}
		D = Integer.parseInt(br.readLine());

		delete(D);
		
		// 0 이상 정수의 종류 개수.
//		for(int i=0; i<N; i++) {
//			if(arr[i] < 0) continue;
//			if(visited[arr[i]] == true) continue;
//			else {
//				visited[arr[i]] = true;
//				cnt++;
//			}
//		}
		
		count(root);
		
		System.out.println(cnt);
	}

	static void delete(int d) {
		arr[d] = -2;
		for(int i=0; i<N; i++) {
			if(arr[i] == d)
				delete(i);
		}
	}
	
	/* 무조건 0이 root인 건 아님.
	 * (시작이 -1이 아님.)
	 * 
	 * 6
	 * 1 2 3 4 -1 4
	 * 5
	 * 
	 */
	
	static void count(int start) {
		boolean leaf = true;
		visited[start] = true;
		if(arr[start] != -2) {
			
			for(int i=0; i<N; i++) {
				if(arr[i] == start && visited[i] == false) {
					count(i);
					leaf = false;
				}
			}
			if(leaf == true) cnt++;
		}
	}
}
