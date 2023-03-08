package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10157 {
	
	static int[][] arr;
	static int C, R, K;
	static int[] dr = {0, 1, 0, -1};	// 우, 하, 좌, 상
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		if(K > R * C) {
			System.out.println(0);
			return;
		}
		
		arr = new int[C][R];
		
		int r=0, c=0, dir=0, num=1;
		while(num != K) {
			
			arr[r][c] = num;
			int new_r = r + dr[dir];
			int new_c = c + dc[dir];
			
			if( new_c < 0 || new_c >= R || new_r < 0 || new_r >= C || arr[new_r][new_c] != 0) {
				dir++;
				if(dir == 4) dir = 0;
				new_r = r + dr[dir];
				new_c = c + dc[dir];
			}
			r = new_r;
			c = new_c;
			num++;
		}
		
		System.out.println((r+1) + " " + (c+1));
	}
}
