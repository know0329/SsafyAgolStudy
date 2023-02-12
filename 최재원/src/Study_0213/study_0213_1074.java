package Study_0213;

import java.util.Scanner;

public class study_0213_1074 {
	
	static int N, R, C, cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		C = sc.nextInt();
		
//		visit((int) Math.pow(2,N),R,C);
		visit1(N,R,C);
		
		sc.close();
	}
	
	private static void visit(int size, int r, int c) {
		// size는 입력 받은 변의 길이로, 2의 N 제곱. r, c는 방문 좌표 위치.
		if(size == 1) {
			System.out.println(cnt);
			return;
		}
		// (r,c)의 구역 위 위치 파악.
		int n = size / 2;
		// 구역 1
		if( r < n && c < n ) {
			visit(n,r,c);
		}
		// 구역 2
		else if( r < n && c < n+n ) {
			cnt += n * n;
			visit(n,r,c-n);
		}
		// 구역 3
		else if( r < n+n && c < n ) {
			cnt += n * n * 2;
			visit(n,r-n,c);
		}
		// 구역 4
		else if( r < n+n && c < n+n) {
			cnt += n * n * 3;
			visit(n,r-n,c-n);
		}
	}
	
	// visit(N,R,C); 으로 입력받은 N을 바로 넣어주고, 
	// visit 함수 안에서  int total_size = (int) Math.pow(2,size); 해주었을 때.
	// 에러가 났던 것 같은데 ..?
	private static void visit1(int size, int r, int c) {
		// size는 입력 받은 N. r, c는 방문 좌표 위치.
		// total_size는 한 변의 길이인 2의 N 제곱.
		int total_size = (int) Math.pow(2,size);
		if(total_size == 1) {
			System.out.println(cnt);
			return;
		}
		
		// (r,c)의 구역 위 위치 파악.
		int n = total_size / 2;
		// 구역 1
		if( r < n && c < n ) {
			visit(n,r,c);
		}
		// 구역 2
		else if( r < n && c < n+n ) {
			cnt += n * n;
			visit(n,r,c-n);
		}
		// 구역 3
		else if( r < n+n && c < n ) {
			cnt += n * n * 2;
			visit(n,r-n,c);
		}
		// 구역 4
		else if( r < n+n && c < n+n) {
			cnt += n * n * 3;
			visit(n,r-n,c-n);
		}
	}
}
