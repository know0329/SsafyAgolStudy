package study_0216;

import java.util.Scanner;

/*
 * 1. 25개의 자리 중 7자리를 선택
 * 2. 선택한 7자리 중 S가 4개 이상인지 체크
 * 3. 4이상이라면, 7자리가 인접한지 체크
 * 4. 2와 3 조건을 만족한다면 결과 +1
 */

public class Main_1941_7princess {
	
	static int cnt = 0;
	static char[][] princess = new char[5][5];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<5; i++) {
			princess[i] = sc.next().toCharArray();
		}
		
		dfs();
		
		sc.close();
	}
	
	static void dfs() {
		check();
	}
	
	static boolean check() {
		return true;
	}
}
