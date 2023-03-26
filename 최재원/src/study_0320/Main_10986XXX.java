package study_BOJ;

import java.util.Scanner;

public class Main_10986XXX {
	
	static int N, M, cnt;
	static int[] input;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		input = new int[N*3];
		cnt = 0;
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt(); 
		}
		
		find(input);
		
		sc.close();
	}
	
	static void find(int[] arr) {
//		arr[0];
//		arr[0] + arr[1];
//		arr[0] + arr[1] + arr[2];
//		arr[0] + arr[1] + arr[2] + arr[3];
//		arr[0] + arr[1] + arr[2] + arr[3] + arr[4];
//		12312
//		12012
//		0 1
//		1 2
//		2 2
	}
}
