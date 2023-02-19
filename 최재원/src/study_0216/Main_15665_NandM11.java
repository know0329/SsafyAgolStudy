package study_0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_15665_NandM11 {
	private static int N;
	private static int M;
	private static int[] inputArr;
	private static int[] resultArr;
	static StringBuffer result = new StringBuffer();
	
	public static void main(String[] args) {
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		// N : 입력받는 배열 element 갯수.
//		N = Integer.parseInt(st.nextToken());
		// M : 출력을 몇 줄로 할 것인지.
//		M = Integer.parseInt(st.nextToken());
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		inputArr = new int[N];
		resultArr = new int[M];
		
		for(int i=0; i<N; i++) {
//			inputArr[i] = Integer.parseInt(st.nextToken());
			inputArr[i] = sc.nextInt();
		}

		Arrays.sort(inputArr);
		
		dfs(0);
		System.out.println(result);
	}
	
	// N과 M이 같을 때, arrayIndex Error
	private static void dfs(int depth) {
		if(depth < M) {
			for(int i=0; i<=M; i++) {
				resultArr[depth] = inputArr[i];
				dfs(depth+1);
			}
		}else {
			for(int i=0; i<resultArr.length; i++) {
				result.append(resultArr[i] + " ");
			}
			result.append("\n");
		}
	}
}
