package study_0221;

import java.util.Arrays;
import java.util.Scanner;

public class Main_6603 {
	
	static boolean[] visited;
	static int[] S;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			// 출력 초기화
			sb = new StringBuilder();
			
			// 입력 받고 배열로 저장
			int K = sc.nextInt();
			if(K == 0) break;
			visited = new boolean[K];
			S = new int[K];
			for(int i=0; i<K; i++) {
				S[i] = sc.nextInt();
			}
			// 정렬
			Arrays.sort(S);
			// 6개 뽑아서 조합
			comb(0,S.length,6);
			
			System.out.println(sb);
		}
		sc.close();
	}
	
	// nCr
	static public void comb(int start, int n, int r) {
		if(r==0) {
			for(int i=0; i<n; i++)
				if(visited[i] == true) sb.append(S[i]).append(" ");
			sb.append("\n");
		}else {
			for(int i=start; i<n; i++) {
				visited[i] = true;
				// 직전에 선택한 i를 제외한, 그 이후 값들로 다시 comb
				// 제외된 수를 뺀, r-1개를 선택해야함.
				comb(i+1,n,r-1);
				visited[i] = false;
			}
		}
	}
}
