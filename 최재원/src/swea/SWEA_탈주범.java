package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_탈주범 {
	
	static int T, N, M, R, C, L;
	static int[][] arr;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static int[][] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			arr = new int[N][M];
			visited = new int[N][M];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 입력 /////////////////////////////////////////////////////
			
			dfs(R,C,1);
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					System.out.print(visited[i][j] + " ");
				}
				System.out.println();
			}
			
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int x, int y, int depth) {
		visited[x][y] = depth;
		if(depth == L) {
//			System.out.println("끝");
			return;
		}
		int now = arr[x][y];
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
			int next = arr[nx][ny];
			if( next == 0 ) continue;
			visited[nx][ny] = 1;
			
			if( next == 1 ) dfs(nx,ny,depth+1);
			else if(next == 2) {
				
			}
			
			// 상
			if(i == 0) {
//				if( now == 3 || now == 5 || now == 6 ) continue;
				if( next == 1 || next == 2 || next == 5 || next == 6 ) {
//					visited[nx][ny] = 1;
					dfs(nx,ny,depth+1);
				}
//				else dfs(x,y,depth+1);
			}
			// 하
			else if(i == 1) {
//				if( now == 3 || now == 4 || now == 7 ) continue;
				if( next == 1 || next == 2 || next == 4 || next == 7 ) {
//					visited[nx][ny] = 1;
					dfs(nx,ny,depth+1);
				}
//				else dfs(x,y,depth+1); 
			}
			// 좌
			else if(i == 2) {
//				if( now == 2 || now == 4 || now == 5 ) continue;
				if( next == 1 || next == 3 || next == 4 || next == 5 ) {
//					visited[nx][ny] = 1;
					dfs(nx,ny,depth+1);
				}
//				else dfs(x,y,depth+1); 
			}
			// 우
			else if(i == 3) {
//				if( now == 2 || now == 6 || now == 7 ) continue;
				if( next == 1 || next == 3 || next == 6 || next == 7 ) {
//					visited[nx][ny] = 1;
					dfs(nx,ny,depth+1);
				}
//				else dfs(x,y,depth+1); 
			}
			dfs(x,y,depth+1);
		}
	}
	
}
