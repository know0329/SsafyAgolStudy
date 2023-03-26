package study_0320;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1799 {
	
	static int N;
	static int[] result = new int[2];
	static int[][] map;
	static int[] dx = {-1, -1};
	static int[] dy = {1, -1};
	static boolean[][] visited, colors;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		colors = new boolean[N][N];
		visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 흰 칸, 검정 칸 구분.
				colors[i][j] = (i%2==0 && j%2==0) || (i%2!=0 && j%2!=0);
			}
		}
		// 검정칸 탐색
		solve(-1, 0, true);
		// 흰칸 탐색
		solve(-1, 0, false);
		
		System.out.println(result[0] + result[1]);
		
		
	}
	
	static void solve(int index, int cnt, boolean black) {
		for(int i=index+1; i<N*N; i++) {
			int x = i / N;
			int y = i % N;
			
			// 현재 탐색중인 색이 아니거나, 비숍을 놓을 수 없거나, 대각선에 비숍이 존재하거나
			if(colors[x][y] != black || map[x][y] == 0 || !check(x,y)) continue;
			
			visited[x][y] = true;
			solve(i,cnt+1,black);
			visited[x][y] = false; 
		}
		
		// 결과 최대인지 확인 후 삽입.
		if(black) {
			result[0] = Math.max(result[0], cnt);
		}else {
			result[1] = Math.max(result[1], cnt);
		}
	}
	static boolean check(int x, int y) {
		// 좌측 하단부터 우측 하단순으로 탐색하므로 윗 대각선의 비숍만 체크한다.
		for(int i=0; i<2; i++) {
			int nx = x;
			int ny = y;
			while(true) {
				if(nx<0 || ny<0 || nx>=N || ny>=N) break;
				if(visited[nx][ny]) return false;
				nx += dx[i];
				ny += dy[i];
			}
		}
		return true;
	}
}
