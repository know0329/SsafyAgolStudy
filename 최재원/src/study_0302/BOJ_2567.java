package study_0302;

import java.util.Scanner;

public class BOJ_2567 {
	
	static int[][] arr = new int[102][102];
	static int result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		result = 0;
		for(int n=0; n<N; n++) {
			
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for(int i=x+1; i<x+11; i++) {
				for(int j=y+1; j<y+11; j++) {
					if(arr[i][j] == 1) continue;
					else arr[i][j] = 1;
				}
			}
		}
		
		for(int i=1; i<101; i++) {
			for(int j=1; j<101; j++) {
				
//				if(i > 0 && i<99 && j<99 && j>0) {
//					if(arr[i][j] == 1 && arr[i-1][j] == 0 ) result++;
//					if(arr[i][j] == 1 && arr[i+1][j] == 0 ) result++;
//					if(arr[i][j] == 1 && arr[i][j-1] == 0 ) result++;
//					if(arr[i][j] == 1 && arr[i][j+1] == 0 ) result++;
//				}else {
//					
//				}
				if(arr[i][j] == 1 && arr[i-1][j] == 0 ) result++;
				if(arr[i][j] == 1 && arr[i+1][j] == 0 ) result++;
				if(arr[i][j] == 1 && arr[i][j-1] == 0 ) result++;
				if(arr[i][j] == 1 && arr[i][j+1] == 0 ) result++;
			}
		}
		System.out.println(result);
	}
}
