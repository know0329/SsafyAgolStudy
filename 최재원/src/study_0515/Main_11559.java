package study_0515;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://moonsbeen.tistory.com/213
// https://skdltm117.tistory.com/50

public class Main_11559 {
	
	static int result;
	static char[][] arr = new char[12][6];
	static boolean[][] visited;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int deltas[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		arr = new int[12][6];
//		for(int i=0; i<12; i++) {
//			String str = br.readLine();
//			for(int j=0; j<6; j++) {
//				char c = str.charAt(j);
//				if(c == 'R') 	arr[i][j] = 1;
//				else if(c == 'G') arr[i][j] = 2;
//				else if(c == 'B') arr[i][j] = 3;
//				else if(c == 'P') arr[i][j] = 4;
//				else if(c == 'Y') arr[i][j] = 5;
//				else arr[i][j] = 0;
//			}
//		}
		for (int i = 0; i < 12; i++) {
            String str = br.readLine();
            for (int j = 0; j < 6; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
//		for(int i=0; i<12; i++) {
//			visited = new boolean[12][6];
//		}
		result = 0;
		while(true) {
			visited = new boolean[12][6];
			int cnt = 0;
			for(int i=0; i<12; i++) {
				for(int j=0; j<6; j++) {
					// '.'이 아닌 값이 나오면, 사방을 bfs 탐색.
					if(!visited[i][j] && arr[i][j] != '.') {
						// bfs에서 list 크기 4이상이고 '.'로 바꿔줬다면 cnt++;
						if(bfs(i,j)) 
							cnt++;
					}
				}
			}
			// bfs 수행 한번도 안하면 끝.
			if(cnt == 0) break;
			else {
				// 수행하면 result++;	
				result++;
				// 중력.
				fallDown();
			}
		}
		System.out.println(result);
	}
	
	static void fallDown() {
		for (int j=0; j<6; j++) {
			for (int i=11; i>=0; i--) {
            	// 맨 아래부터 탐색, 뿌요 나오면 다시 아래로.
                if (arr[i][j] != '.') {
                    int nr = i;
                    while (true) {
                        nr++;
                        if (isIn(nr, j) && arr[nr][j] == '.') {
                            arr[nr][j] = arr[nr - 1][j];
                            arr[nr - 1][j] = '.';
                        }
                        else break;
                    }
                }
            }
        }
	}
	
	static boolean bfs(int r, int c) {
        Queue<Position> queue = new LinkedList<>();
        // 사방을 탐색하면서, 같은 색을 list에 저장.
        List<Position> list = new ArrayList<>();
        queue.offer(new Position(r, c));
        list.add(new Position(r, c));
        visited[r][c] = true;
        char color = arr[r][c];
        while (!queue.isEmpty()) {
            Position temp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nr = temp.r + deltas[i][0];
                int nc = temp.c + deltas[i][1];
                // 같은 색이고, 방문하지 않은 곳.
                if (isIn(nr, nc) && arr[nr][nc] == color && !visited[nr][nc]) {
                    list.add(new Position(nr, nc));
                    queue.offer(new Position(nr, nc));
                    visited[nr][nc] = true;
                }
            }
        }
        // list에 4개 이상 값이 저장 == 뿌요가 4개 이상 붙어있음.
        // list에 저장된 좌표를 '.'으로 변경.
        if (list.size() >= 4) {
            for (Position temp : list) {
            	arr[temp.r][temp.c] = '.';
            }
            return true;
        }
        return false;
    }
	
	static boolean isIn(int r, int c) {
        return r >= 0 && r < 12 && c >= 0 && c < 6;
    }
	
	static class Position {
        int r, c;
        public Position(int r, int c) {
            super();
            this.r = r;
            this.c = c;
        }
    }
}
