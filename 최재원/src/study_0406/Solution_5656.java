package study_0406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 1. 어디에 떨어뜨릴 것인가 (중복 가능) (where 함수)
 * 2. 떨어트리고 난 뒤, 연쇄 반응 (shoot 함수, bfs 함수)
 * 3. 공중에 떠있는 수를 아래로 (down 함수)
 * 4. 0이 아닌 수의 개수 (cntNotZero 함수)
 * 5. 다시 어디에 떨어뜨릴 것인지 결정 + 배열 초기화 (initArr 함수)
 * 
 */

public class Solution_5656 {
	
	static int T, N, W, H, result;
	static int[][] arr, copy;
	static int[] startWhere;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			// arr: 탐색할 배열, copy: arr를 초기화할 배열
			// startWhere: 출발 위치들을 담은 배열. 해당 위치를 시작으로 순차적으로 탐색.
			arr = new int[H][W];
			copy = new int[H][W];
			startWhere = new int[N];
			result = Integer.MAX_VALUE;
			// 입력
			for(int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) 
					arr[i][j] = copy[i][j] = Integer.parseInt(st.nextToken());
			}
			// 출발 위치 지정해 탐색.
			where(0);
			sb.append("#" + t + " " + result + "\n");
		}
		System.out.println(sb);
	}
	
	// 출발 위치 지정 (순열)
	static void where(int cnt) {
		// 출발 위치가 N개 전부 정해지면
		if(cnt == N) {
			// 출발 위치들이 정해지면 탐색
			shoot(startWhere);
			// '최소값 <-> 0이 아닌 개수' 비교해 result에 저장.
			result = Math.min(result, cntNotZero());
			// 배열 초기화하여 재탐색
			initArr();
			return;
		}
		for(int i=0; i<W; i++) {
			startWhere[cnt] = i;
			where(cnt+1);
		}
	}
	// 구슬 떨어뜨리기
	static void shoot(int[] temp) {
		int x = 0;
		int y = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<H; j++) 
				// 아래로 내려가면서, 0이 아닌 곳 발견
				if(arr[j][temp[i]] != 0) {
					x = j;
					y = temp[i];
					break;
				}
			
			// shoot
			bfs(x,y);
			// 떠있는 블록들 아래로.
			down();
		}
	}
	// 연쇄 반응
	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {x, y, arr[x][y]});
		arr[x][y] = 0;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int power = cur[2]; // 몇 칸을 갈 수 있는지
			
			for(int i=1; i<power; i++) 
				for(int j=0; j<4; j++) {
					int nx = cur[0] + dx[j]*i;
					int ny = cur[1] + dy[j]*i;
					
					if(nx<0 || ny<0 || nx>=H || ny>=W 
							|| arr[nx][ny]==0) continue;
					if(arr[nx][ny] != 0) {
						q.add(new int[] {nx, ny, arr[nx][ny]});
						arr[nx][ny] = 0;
					}
				}
		}
	}
	// 공중에 떠있는 수를 아래로
	static void down() {
		Stack<Integer> s = new Stack<>();
		for(int i=0; i<W; i++) {
			// 해당 열 위에서부터, 0이 아닌 수 스택에 저장
			for(int j=0; j<H; j++) 
				if(arr[j][i] != 0)
					s.add(arr[j][i]);
			// 해당 열 밑에서부터, 스택에서 꺼내 저장
			for(int j=H-1; j>=0; j--) {
				if(s.isEmpty())
					arr[j][i] = 0;
				else
					arr[j][i] = s.pop();
			}
		}
	}
	// 배열 초기화
	static void initArr() {
		for(int i=0; i<H; i++) 
			for(int j=0; j<W; j++) 
				arr[i][j] = copy[i][j];
	}
	
	// 0이 아닌 곳 개수 count
	static int cntNotZero() {
		int count = 0;
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(arr[i][j] != 0)
					count++;
			}
		}
		return count;
	}
}
