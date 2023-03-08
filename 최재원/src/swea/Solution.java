package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	/*
	 * 이차원 배열에 사과 위치 1, 2, 3 등... 순서로 나타남.
	 * 사과를 순서대로 먹으러 이동할 것, 단 회전은 시계 방향(오른쪽)만 가능.
	 */
	
	static int T, N, M, result, flag;
	static int X, Y, NX, NY;
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();
//	static int[] dx = {1,0,-1,0};	// 우, 하, 좌, 상
//	static int[] dy = {0,-1,0,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			M = 0;
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j] != 0) M++;
				}
			}
			// input ///////////////////////////////////
			X = 0;
			Y = 0;
			result = 1;
			flag = 1; // 우0 하1 좌2 상3
			
			find(1);
			
			sb.append("#" + t + " ");
			
			solve(NX,NY,2);
			
			result = 1;
			flag = 1;
		}
		
		System.out.println(sb);
		
	}
	
	static void solve(int x, int y, int m) {
		
		if(m > M) {
//			System.out.println(result);
			sb.append(result + "\n");
			return;
		}
		find(m);
//		System.out.println("현재 좌표는, (" + x + "," + y + ")");
//		System.out.println("찾은 좌표는, (" + NX + "," + NY + ")");
		
		int dx = NX - x;
		int dy = NY - y;
		
//		System.out.println("현재 위치부터 이동 시작: ");
		
		// 3 구역
		if(dx < 0 && dy > 0) {
			// 방향 '하' 중이면
			if(flag == 1) {
//				System.out.println("하->턴턴턴->좌");
				result += 3;
				flag = 0; // 방향은 '우'로
			}
			// 방향 '우' 중이면
			else if(flag == 0) {
//				System.out.println("우->턴턴턴->상");
				result += 3; // 방향 '상'으로
				flag = 3;
			}
			// 방향 '좌' 중이면
			else if(flag == 2) {
//				System.out.println("좌->턴턴->우");
				result += 2;
				flag = 0; // 방향 '우'로
			}
			// 방향 '상' 중이면
			else if(flag == 3) {
//				System.out.println("상->턴->우");
				result += 1;
				flag = 0; // 방향 '우'로
			}
		}
		
		// 4 구역
		if(dx > 0 && dy > 0) {
			// 방향 '하' 중이면
			if(flag == 1) {
//				System.out.println("하->턴턴턴->우");
				result += 3;
				flag = 0; // 방향은 '우'로
			}
			// 방향 '우' 중이면
			else if(flag == 0) {
//				System.out.println("우->턴->하");
				result += 1;
				flag = 1; // 방향 '하'로
			}
			// 방향 '좌' 중이면
			else if(flag == 2) {
//				System.out.println("좌->턴턴턴->하");
				result += 3;
				flag = 1; // 방향 '하'로
			}
			// 방향 '상' 중이면
			else if(flag == 3) {
//				System.out.println("상->턴턴->하");
				result += 2;
				flag = 1; // 방향 '하'로
			}
		}
		
		// 1 구역
		if(dx > 0 && dy < 0) {
			// 방향 '하' 중이면
			if(flag == 1) {
//				System.out.println("하->턴->좌");
				result += 1;
				flag = 2; // 방향은 '좌'로
			}
			// 방향 '우' 중이면
			else if(flag == 0) {
//				System.out.println("우->턴턴->좌");
				result += 2;
				flag = 2; // 방향 '좌'로
			}
			// 방향 '좌' 중이면
			else if(flag == 2) {
//				System.out.println("좌->턴턴턴->하");
				result += 3;
				flag = 1; // 방향 '하'로
			}
			// 방향 '상' 중이면
			else if(flag == 3) {
//				System.out.println("상->턴턴턴->좌");
				result += 3;
				flag = 2; // 방향 '좌'로
			}
		}
		
		// 2 구역
		if(dx < 0 && dy < 0) {
			// 방향 '하' 중이면
			if(flag == 1) {
//				System.out.println("하->턴턴->상");
				result += 2;
				flag = 3; // 방향은 '상'으로
			}
			// 방향 '우' 중이면
			else if(flag == 0) {
//				System.out.println("우->턴턴턴->상");
				result += 3;
				flag = 3; // 방향 '상'으로
			}
			// 방향 '좌' 중이면
			else if(flag == 2) {
//				System.out.println("좌->턴->상");
				result += 1;
				flag = 3; // 방향 '상'으로
			}
			// 방향 '상' 중이면
			else if(flag == 3) {
//				System.out.println("상->턴턴턴->좌");
				result += 3;
				flag = 2; // 방향 '좌'로
			}
		}
		solve(NX, NY, m+1);
	}
	
	static void find(int m) {
		for(int i=0; i<N; i++) 
			for(int j=0; j<N; j++) 
				if(arr[i][j] == m) {
					NX = i;
					NY = j;
					return;
				}
	}
}
