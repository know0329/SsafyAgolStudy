package study_0220;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main_1759 {
	static int L, C;
	static StringBuffer sb = new StringBuffer();

	static char[] arr2;
	static char[] result2;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		C = sc.nextInt();
		
		result2 = new char[L];
		arr2 = new char[C];
		
		for(int i=0; i<C; i++) {
			arr2[i] = sc.next().charAt(0);
		}
		
		Arrays.sort(arr2);
		dfs(0,0);
//		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb);
		
		sc.close();
		
	}
	
	private static void dfs(int start, int depth) {
		if(depth == L) {
			// 조건(정렬, 중복X, 자음&모음 개수) 체크 후 출력
			if(checkArr()) {
				char before = result2[0];
				for(int k=1; k<4; k++) {
					if(before == result2[k]) return;
					else before = result2[k];
				}
				for(int k=0; k<4; k++) {
					sb.append(result2[k]);
				}
				sb.append("\n");
				
			}
			return;
		}
		
		// ***********중복 체크 여기서*************
		char before = result2[0];
		for(int i=start; i<arr2.length; i++) {
			if(i == 0) {
				result2[depth] = arr2[i];
				before = arr2[0];
				dfs(i+1, depth+1);				// i+1 <-> start+1
			}else {
				if(before != arr2[i]) {
					result2[depth] = arr2[i];
					before = arr2[i];
					dfs(i+1, depth+1);				// i+1 <-> start+1	
					
				}else {
					continue;		
				}

			}
		}
	}
	
	private static boolean checkArr() {
		// 모음 & 자음 개수
		int mo = 0;
		int za = 0;

		for(int i=0; i<L; i++) {
			char now = result2[i];

			// 모음 & 자음 개수 확인
			if(now=='a' || now=='e' || now=='i'
					|| now=='o' || now=='u') 
				mo++;
			else za++;
		}
		if(mo < 1 || za < 2) {
			return false;
		}else {
			return true;
		}
	}
}
