package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution2 {
	
	static int T, N, phoX, phoY, result, cnt;
	static int[][] arr;
	static Queue<Integer> qX = new LinkedList<Integer>();
	static Queue<Integer> qY = new LinkedList<Integer>();
	static boolean[][] visited;
	static boolean[][] visit2;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());		// 총 테스트 케이스 수
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());	// 장기판 크기
			arr = new int[N][N];
			visited = new boolean[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j] == 2) {
						phoX = i;
						phoY = j;
					}
				}
			}
			// input /////////////////////////////////////////////////////////////
			
			cnt = 0;
			result = 0;
			
//			System.out.println("포 시작 위치 : " + phoX + " " + phoY);
			
			findNext(phoX,phoY); 	// 점프 한번 수행한 것.
//			result = bfs();
			
			visit2 = new boolean[N][N];
			
			for(int i=0; i<=qX.size(); i++) {
				
				int nX = qX.poll();
				int nY = qY.poll();
				if(visit2[nX][nY] == false) {
//					System.out.println(nX + " " + nY);
					findNext(nX,nY);					
				}
				else continue;
			}

//			for(int i=0; i<=qX.size(); i++) {
//				int nX = qX.poll();
//				int nY = qY.poll();
//				System.out.println(nX + " " + nY);
//				findNext(nX,nY);
//			}
			
			System.out.println("#" + t + " " + result);
		}
	}
	
	static void bfs() {
		
		cnt++;
		
		if(cnt == 3) {
			System.out.println(result);
			return;
		}
		
		for(int i=0; i<=qX.size(); i++) {
			int nX = qX.poll();
			int nY = qY.poll();
			
			findNext(nX, nY);
		}
		
		bfs();
//		while(!qX.isEmpty()) {
//			int nowX = qX.poll();
//			int nowY = qY.poll();
//			
//			
//			findNext(nowX,nowY);
//			
//		}
		
//		int nowX = qX.poll();
//		int nowY = qY.poll();
		
//		findNext(nowX, nowY);
	}

	static void findNext(int x, int y) {
		// 점프 가능 구간 확인
		// 가로
		for(int i=0; i<N; i++) {
			if(visited[i][y] == true) continue;
			if(arr[i][y] != 0) {
				if(i < x && i >= 1) {
					for(int j=0; j<i; j++) {
						if(visited[j][y] == true) continue;
						if(arr[j][y] == 1 && visited[j][y] == false) {
							result += 1;
//							arr[j][y] = 0;
							visited[j][y] = true;
						}
						if(visited[j][y] == false) {
							qX.offer(j);
							qY.offer(y);							
						}
					}
				}
				if( i > x && i<= N-1) {
					for(int j=i+1; j<N; j++) {
						if(visited[j][y] == true) continue;
						if(arr[j][y] == 1 && visited[j][y] == false) {
							result += 1;
//							arr[j][y] = 0;
							visited[j][y] = true;
						}
						if (visited[j][y] == false) {
							qX.offer(j);
							qY.offer(y);
						}
					}
				}
			} else continue;
		}
		
		// 세로
		for(int i=0; i<N; i++) {
			if(visited[x][i] == true) continue;
			if(arr[x][i] != 0) {
				if(i < y && i >= 1) {
					for(int j=0; j<i; j++) {
						if(visited[x][j] == true) continue;
						if(arr[x][j] == 1 && visited[x][j] == false) {
							result += 1;
//							arr[x][j] = 0;
							visited[x][j] = true;
						}
						if(visited[x][j] == false) {
							qX.offer(x);
							qY.offer(j);							
						}
					}
				}
				if( i > y && i<= N-1) {
					for(int j=i; j<N; j++) {
						if(visited[x][j] == true) continue;
						if(arr[x][j] == 1 && visited[x][j] == false) {
							result += 1;
//							arr[x][j] = 0;
							visited[x][j] = true;
						}
						if(visited[x][j] == false) {
							qX.offer(x);
							qY.offer(j);
						}
					}
				}
			} else continue;
		}
	}


}
