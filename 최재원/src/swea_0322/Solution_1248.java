package swea_0322;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1248 {
	static int T, V, E, Node1, Node2, flag, root;
	static int[] arr1, arr2;
	static int[] visit1, visit2;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			Node1 = Integer.parseInt(st.nextToken());
			Node2 = Integer.parseInt(st.nextToken());
			arr1 = new int[V+1];
			arr2 = new int[V+1];
			visit1 = new int[V+1];
			visit2 = new int[V+1];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<E; i++) {
				int node = Integer.parseInt(st.nextToken());
				int edge = Integer.parseInt(st.nextToken());
				if(arr1[node] != 0) arr2[node] = edge;
				else arr1[node] = edge;
			}
//			System.out.println(Arrays.toString(arr1));
//			System.out.println(Arrays.toString(arr2));
			
			// 방문하는 부모 node를 visit 배열에 저장.
			// visit1과 visit2가 겹치는 부분이 있다면 공통 부모.
			flag = 0;
			findParent(Node1,visit1);
			flag = 0;
			findParent(Node2,visit2);
			// subTree의 root 찾기
			root = findSubRoot();
			// root를 시작으로 자식 찾기
			flag = 1;
			findChild(root);
			sb.append("#" + t + " " + root + " " + flag + "\n");
		}
		System.out.println(sb);
	}
	static void findParent(int child, int[] arr) {
		if(child == 1) {
//			System.out.println(Arrays.toString(arr));
			return;
		}
		for(int i=1; i<V+1; i++) {
			if(arr2[i] == child) {
				flag++;
				arr[i] = flag;
				findParent(i,arr);
			}else if(arr1[i] == child) {
				flag++;
				arr[i] = flag;
				findParent(i,arr);
			}
		}
	}
	static int findSubRoot() {
		int selectNode = Integer.MAX_VALUE;
		int subRoot = -1;
		for(int i=1; i<V+1; i++) {
			if(visit1[i] != 0 && visit2[i] != 0) {
				if(visit1[i]+visit2[i] - selectNode < 0) {
					subRoot = i;
					selectNode = visit1[i]+visit2[i];
				}
			}
		}
		return subRoot;
	}
	static void findChild(int r) {
		if(arr2[r] != 0) {
			flag++;
			findChild(arr2[r]);
		}
		if(arr1[r] != 0) {
			flag++;
			findChild(arr1[r]);
		}
		return;
	}
}
