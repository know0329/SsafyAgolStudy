package study_0227;

import java.util.Scanner;

public class Main_2630 {
	
	static int[][] input;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		// 입력 이차원 배열로
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		input = new int[T][T];
		for(int i=0; i<T; i++) {
			for(int j=0; j<T; j++) {
				input[i][j] = sc.nextInt();
			}
		}
		
		// 색종이 나누기
		dfs(0,0,T);
		
		// 결과 출력
		int result_b = 0;
		int result_w = 0;
		for(int i=0; i<sb.length(); i++) {
			if(sb.charAt(i) == '1') result_b++;
			else result_w++;
		}
		System.out.println(result_w);
		System.out.println(result_b);
		
		sc.close();
		
	}
	
	// x y 좌표 & 탐색 size
	public static void dfs(int x, int y, int size) {
		int start = input[x][y];
		int flag = -1;
		// 출발 좌표부터 size 만큼 탐색
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				if(start == input[i][j]) continue;
				// start와 다른 값이 나오면 break, size/2 하여 다시 dfs();
				else {
					flag = 1;
					break;
				}
			}
			if(flag == 1) break;
		}
		
		// size 나눠주고 다시 dfs
		if(flag == 1) {
			int new_size = size/2;
			dfs(x, y, new_size);					// 1구역
			dfs(x, y+new_size, new_size);			// 2구역
			dfs(x+new_size, y, new_size);			// 3구역
			dfs(x+new_size, y+new_size, new_size);	// 4구역
		}else {
			sb.append(start);
			return;
		}
	}
}
