package study_0227;

import java.util.Scanner;

public class Main_2563 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int result = 0;
		int[][] white = new int[100][100];
		
		int T = sc.nextInt();
		for(int t=0; t<T; t++) {
			// 입력값 2가지 -> 시작 좌표
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			// (x,y) ~ (x+10,y+10) 사이 확인, 0이면 1로, result++
			for(int i=x; i<x+10; i++) {
				for(int j=y; j<y+10; j++) {
					if(white[i][j] == 1) continue;
					else {
						result++;
						white[i][j] = 1;
					}
				}
			}
		}
		
		System.out.println(result);
		sc.close();
	}
}
