package algorithm;

import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main4485 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static int n, cnt;
	static int[][] arr;
	static int[][] v;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static Queue<Point> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		while(true) {
			cnt++;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			if(n == 0) break;
			arr = new int[n][n];
			v = new int[n][n];
			fillv(v);
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			q.add(new Point(0,0));
			f(0,0);
			makeAnswer(cnt, v[n-1][n-1]);
		}
		System.out.println(sb);
	}
	
	private static void f(int y,int x) {
		while(!q.isEmpty()) {
			Point cur = q.poll();
			for(int i=0;i<4;i++) {
				int ny = cur.y+dy[i];
				int nx = cur.x+dx[i];
				if(ny < 0 || nx < 0 || ny >= n || nx >= n || v[ny][nx] <= v[cur.y][cur.x] + arr[ny][nx]) continue;
				v[ny][nx] = v[cur.y][cur.x] + arr[ny][nx];
				q.add(new Point(nx,ny));
			}
		}
	}
	
	private static void fillv(int[][] visit) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				v[i][j] = 987654321;
			}
		}
	}
	
	private static void makeAnswer(int i, int ans) {
		sb.append("Problem ");
		sb.append(i);
		sb.append(": ");
		sb.append(ans);
		sb.append("\n");
	}
}