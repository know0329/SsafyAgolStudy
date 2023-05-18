package study_0518;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main_16236 {
	
	static int N, sharkX, sharkY, sharkSize, tempSize, answer;
	static int[][] arr;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		sharkSize = 2;
		tempSize = 0;
		answer = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 9) {
					sharkX = i;
					sharkY = j;
					arr[i][j] = 0;
				}
			}
		}
		
		// 탐색
		while (true) {
            int x = Integer.MAX_VALUE;
            int y = Integer.MAX_VALUE;
            int d = Integer.MAX_VALUE;

            Queue<Point> queue = new LinkedList<>();
            int[][] dist = new int[N][N]; // 이동 거리 저장 및 사이클 방지
            queue.add(new Point(sharkX, sharkY));

            while (!queue.isEmpty()) { // bfs 탐색
            	Point cur = queue.poll();

                for (int k = 0; k < 4; k++) { // 4방향 순회
                    int nx = cur.x + dx[k];
                    int ny = cur.y + dy[k];
                    // 범위
                    if ( isIn(nx, ny) ) continue;
                    // 자신보다 큰 물고기
                    if (arr[nx][ny] > sharkSize) continue;
                    // 이미 방문한 위치는 다시 방문 x (사이클 방지)
                    if (dist[nx][ny] != 0) continue;

                    dist[nx][ny] = dist[cur.x][cur.y] + 1; // 이동 횟수 저장

                    // 가까운 물고기 -> 왼쪽 -> 위
                    if (arr[nx][ny] != 0 && arr[nx][ny] < sharkSize) {
                        if (d > dist[nx][ny]) { 
                            d = dist[nx][ny];
                            x = nx;
                            y = ny;
                        } 
                        else if (d == dist[nx][ny]) {
                            if (nx == x) { 
                                if (y > ny) {
                                    x = nx;
                                    y = ny;
                                }
                            } else if (nx < x) { 
                                x = nx;
                                y = ny;
                            }
                        }
                    }
                    queue.add(new Point(nx, ny));
                }
            }

            // 먹을 물고기 X
            if (x == Integer.MAX_VALUE && y == Integer.MAX_VALUE) break;

            answer += dist[x][y];
            arr[x][y] = 0;

            sharkX = x;
            sharkY = y;

            tempSize++;

            // 상어 크기 증가
            if (tempSize == sharkSize) sharkSizeUp();
        }

        System.out.println(answer);
		
	}
	

	
	// 상어 크기 +1
	static void sharkSizeUp() {
		sharkSize++;
		tempSize = 0;
	}
	
	// 지나갈 수 있는 칸인지 확인
	static boolean canGo(int x, int y) {
		if(sharkSize > arr[x][y]) return  true;
		else return false;
	}
	
	// 먹을 수 있는 물고기인지 확인
	static boolean canEat(int x, int y) {
		if(arr[x][y] != 0 && arr[x][y] < sharkSize) return true;
		else return false;
	}
	
	// 범위 안에 있는지 확인
	static boolean isIn(int x, int y) {
		if( x<0 || y<0 || x>=N || y>=N) return true;
		else return false;
	}
	
	static class Point{
		int x;
		int y;
		
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}