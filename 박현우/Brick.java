package algorithm;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

// 시프트 안해주면 좌우 블럭이 달라져서 연쇄폭발이 달라짐 ...
public class Brick {
	static int n, w, h, res;
	static int[][] arr;
	static int[][] org;
	static int[] drop;
	static boolean[][] bomb;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			arr = new int[h][w];
			org = new int[h][w];
			bomb = new boolean[h][w];
			drop = new int[n];
			res = 987654321;

			// 12^4 * 12 * 15 = 3732480
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++)
					org[i][j] = arr[i][j] = Integer.parseInt(st.nextToken());
			}

			f(0);
			
			System.out.println("#" + test_case + " " + res);
		}
	}

	private static void f(int cnt) {
		if (cnt == n) {
			copy();
			Queue<Integer> q = new LinkedList<>();
			
			for (int i = 0; i < n; i++) q.add(drop[i]);
			while (!q.isEmpty()) {
				int now = q.poll();
				Point fc = findPoint(now);
				if(fc.x == -1) continue; // 깨뜨릴 블럭이 없음

				Queue<Point> trigger = new LinkedList<>();
				trigger.add(fc);
				while(!trigger.isEmpty()) {
					Point cur = trigger.poll();
					
					// 터뜨려졌으면 bomb = true
					bomb[cur.x][cur.y] = true;
					
					// 상하좌우
					for (int i = 0; i < 4; i++) {
						// 연쇄폭발 블럭 갯수
						int valid = arr[cur.x][cur.y];
						int ny = cur.x;
						int nx = cur.y;
						while (valid > 1) {		
							valid--;
							// 넣은 좌표한개로 연쇄폭발 값을 누적시켜서 큐에 새로 좌표 넣지 않고 해결한다
							ny += dy[i];
							nx += dx[i];
							if(ny < 0 || nx < 0 || ny >= h || nx >= w) break; // 터뜨릴수있는만큼 다 터뜨림
							if(bomb[ny][nx]) continue; // 이미 터진 곳					
							bomb[ny][nx] = true;
							trigger.add(new Point(ny,nx));
						}
					}					
				}
				// 폭발 1회시 마다 벽돌 시프트 
				shift();
			}

			res = Math.min(chk(), res);

			return;
		}
		// 폭탄이 떨어질 위치를 찾아서 저장
		for (int i = 0; i < w; i++) {
			drop[cnt] = i;
			f(cnt + 1);
		}
	}

	private static void copy() {
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				arr[i][j] = org[i][j];
			}
		}
	}

	private static Point findPoint(int s) {
		for (int i = 0; i < h; i++) {
			if (arr[i][s] != 0 && !bomb[i][s])
				return new Point(i, s);
		}
		return new Point(-1, -1); // 공 떨어질 위치에 블럭 없을 때
	}
	
	private static int chk() {
		int tres = 0;
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				if(arr[i][j] != 0) tres++;
			}
		}
		return tres;
	}
	
	// 터진 곳은 0으로 바꾸고 스택에 쌓은 터지지 않은 블록들을 쌓는다.
	private static void shift() {
		Stack<Integer> s = new Stack<>(); 
		for(int i=0;i<w;i++) {
			for(int j=0;j<h;j++) {
				if(arr[j][i] != 0 && !bomb[j][i]) s.push(arr[j][i]);
				arr[j][i] = 0;
			}
			
			// if(drop[0] == 2 && drop[1] == 2 && drop[2] == 6) System.out.println(s);
			// 한줄 다터뜨리면 한줄 갱신
			for(int j=h-1;j>=0;j--) {
				if(s.isEmpty()) break;
				arr[j][i] = s.pop();
			}
		}
		// 시프트 후 자리가 바뀌므로 불린체크도 다시한다.
		bomb = new boolean[h][w];
	}
	
}