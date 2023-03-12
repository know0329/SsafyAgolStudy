package study_0313;

import java.util.Scanner;

public class Main_2447_별찍기 {
	
	static int N;
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		
		solve(N,0,0);
		stamp();
		
		sc.close();
	}
	
	// size는 호출되는 길이(n*n배열의 n), x, y는 시작 위치
	static void solve(int size, int x, int y) {
		if(size == 1) {
			arr[x][y] = 1;
			return;
		}

		int new_size = size/3;
		for(int i=0; i<3; i++) 
			for(int j=0; j<3; j++) 
				if(!(i==1 && j==1)) 
					solve(new_size, x+i*new_size, y+j*new_size);
		
//		for(int i=x+s; i<x+s*2; i++) {
//			for(int j=y+s; j<y+s*2; j++) {
//				arr[i][j] = 1;
//			}
//		}
		
	}
	
	static void stamp() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j] == 1) 
					sb.append("*");
				else 
					sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
