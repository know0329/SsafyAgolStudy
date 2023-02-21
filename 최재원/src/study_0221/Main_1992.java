package study_0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1992 {
	
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력 받아 배열로 저장.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				// 강제 형 변환 -> 48? 49?
				// arr[i][j] = (int)str.charAt(j);
				// 아스키 코드 이용
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		// 분할 시작
		division(0,0,N);
		System.out.println(sb);
		
	}
	
	public static void division(int x, int y, int size) {
		// 압축 가능 크기인지 확인
		if(check(x,y,size)) {
			sb.append(arr[x][y]);
			return;
		}
		// 아니면 다시 분할
		int new_size = size / 2;
		sb.append("(");
		// 구역 1
		division(x, y, new_size);
		// 구역 2
		division(x, y+new_size, new_size);
		// 구역 3
		division(x+new_size, y, new_size);
		// 구역 4
		division(x+new_size, y+new_size, new_size);
		sb.append(")");
	}
	
	public static boolean check(int x, int y, int size) {
		int first = arr[x][y];
		// 분할 크기만큼 옆-아래 확인
		// 값이 모두 같다면 true, 아니면 false
		for(int i=x;i<x+size;i++)
			for(int j=y; j<y+size; j++)
				if(first != arr[i][j])
					return false;
		return true;
	}
}
