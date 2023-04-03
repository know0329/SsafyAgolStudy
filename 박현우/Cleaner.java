package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Cleaner {
	static int n,m,res; 
	static int sy, sx, dir;
	static int[][] arr;
	static boolean[][] clean;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		sy = Integer.parseInt(st.nextToken());
		sx = Integer.parseInt(st.nextToken());
		dir = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		clean = new boolean[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		f(sy,sx,dir);
		
		System.out.print(res);
	}
	
	private static void f(int y, int x, int d) {
		// 청소기 시작점, 이동하는 곳은 청소가 가능한 곳 이므로 청소갯수 + 1 && 방문체크
		if(!clean[y][x]) res++;
		clean[y][x] = true;
		// System.out.println(y + " " + x + " " + arr[y][x] + " " + res);
		// 현재위치에서 4방향에 청소가능한 곳 없으면
		if(!chk(y, x)) {
			// 후진 (d+2)%4
			int nd = (d+2)%4;
			int ny = y + dy[nd];
			int nx = x + dx[nd];
			if(ny < 0 || nx < 0 || ny >= n || nx >= m || arr[ny][nx] == 1) return; // 후진 불가능하면 종료
			f(ny,nx,d); // 방향 유지하고 후진
			return;
		}		
		
		int nd = (d+3)%4;
		// 방향 앞칸이 청소가능할때까지 회전
		while(true) {
			// 4방향에 청소가능한 곳 있으면 일단 반시계 90도 회전 (d+3)%4
			int ny = y + dy[nd];
			int nx = x + dx[nd];
			if(arr[ny][nx] == 0 && !clean[ny][nx]) {
				f(ny,nx,nd);
				return;
			}
			nd = (nd+3)%4;
		}
	}
	// 4방향에 청소 가능한 곳 있는지 체크(0이면서 방문체크안된 곳)
	private static boolean chk(int y, int x) {
		for(int i=0;i<4;i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			if(ny < 0 || nx < 0 || ny >= n || nx >= m || arr[ny][nx] == 1 || clean[ny][nx]) continue;
			if(arr[ny][nx] == 0 && !clean[ny][nx]) return true;
		}
		return false;
	}
}
