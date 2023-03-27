package samsung01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo2_구미_6반_최재원 {
	static int T, N, x, y, tx, ty;
	static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T= Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			tx = Integer.parseInt(st.nextToken());
			ty = Integer.parseInt(st.nextToken());
//			arr[x][y] = 1;
			arr[tx][ty] = 1;
		}
	}
	static void move(int x0, int y0, int depth) {
		if(x0 < 0 || y0 < 0 || x0>=N || y0>=N) return;
		if(arr[x0][y0] == 1) {
			return;
		}
		
//		int x1 = x0 - 1;
//		int y1 = y0 + 2;
//		move(x1, y1, depth+1);
//		move(x1+2, y1, depth+1);
		// dfs가 아닌 bfs로 구현해야 할 것 같은데 시간이 부족했습니다.
	}
}
