package study_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_25682 {
	
	static int N, M, K;
	static int[][] input;
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		input = new int[N][M];
		// B이면 1, W이면 0인 int 배열로.
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				if(str.charAt(j) == 'B') input[i][j] = 1;
				else input[i][j] = 0;
			}
		}
		
		System.out.println(Math.min(minimal_board(1), minimal_board(0)));
	}
	static int minimal_board(int idx) {
		int count = Integer.MAX_VALUE;
		int[][] prefix_sum = new int[N+1][M+1];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				
				if(j+(K-1) >= M) continue;
				if(i+(K-1) >= N) continue;
				int value;
				if((i%2==0 && j%2==0) || (i%2 != 0 && j%2 != 0)) {
					value = input[i][j] != idx ? 1:0;
				}else {
					value = input[i][j] == idx ? 1:0;
				}
				prefix_sum[i+1][j+1] = prefix_sum[i][j+1] + prefix_sum[i+1][j] - prefix_sum[i][j] + value;
			}
		}
		for(int i = 1; i <= N - K + 1; i++) {
			for(int j = 1; j <= M - K + 1; j++) {
				count = Math.min(count, prefix_sum[i + K - 1][j + K - 1] - prefix_sum[i + K - 1][j - 1] - prefix_sum[i - 1][j + K - 1] + prefix_sum[i - 1][j - 1]);
			}
		}
		return count;
	}
		
}
