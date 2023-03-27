package samsung01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Algo3_구미_6반_최재원 {
	static int T, N, M, C, startX, startY, result;
	static int[][] arr;
	static boolean[][] visited;
	static List<Integer> list;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			// 입력 배열, 방문 배열, 쓰레기 list, 결과 result 초기화.
			arr = new int[N][M];
			visited = new boolean[N][M];
			C = Integer.parseInt(st.nextToken());
			list = new ArrayList<>();
			result = 0;
			// 입력 받기
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					// 입력값이 1일 때, 로봇의 시작 위치
					if(arr[i][j] == 1) {
						startX = i;
						startY = j;
					}
					// 입력값이 1이 아닌 것 중 0이 아니면 쓰레기 위치.
					else if(arr[i][j] != 0) 
						list.add(arr[i][j]);
				}
			}
			
			// 쓰레기 양이 큰 곳부터 방문할 수 있는지 확인할 예정이므로, 내림차순으로 sort해줌.
			Collections.sort(list);
			Collections.reverse(list);
			
			// 쓰레기 주우러 갔다오는 함수.
			clean();
			sb.append("#" + t + " ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	static void clean() {
		// 에너지 C가 0과 같거나 작으면 return
//		if(C <= 0) return;
		for(int i=0; i<list.size(); i++) {
			// 쓰레기 양이 큰 곳부터, 차례로 반복문
			// 해당 쓰레기 양을 가진 곳의 좌표를 확인
			int[] trash = find(list.get(i));
			if(isOk(trash[0],trash[1]) == 0) continue;
			// 쓰레기가 있는 곳의 좌표까지 왕복이 불가능하면 continue, 아니면 else문 수행.
			else {
				// 먼저 로봇의 총 에너지에서 쓰레기를 주우러 갔다온 왕복 거리 에너지를 빼준다.
				C -= isOk(trash[0],trash[1]);
				// 결과값에는 해당하는 쓰레기양을 추가.
				result += list.get(i);
			}
		}
	}
	
	// 로봇의 시작 위치에서 쓰레기 위치까지 왕복 이동이 가능한지 확인
	static int isOk(int x, int y) {
		// 좌표 간의 거리 dis를 구해준다.
		int dis = Math.abs(x-startX) + Math.abs(y-startY);
		// 왕복 거리 dis*2보다 에너지(C)가 높으면 해당 거리를 return. 
		// 그렇지 않으면 0을 리턴.
		if(C >= dis*2) return dis*2;
		else return 0;
	}
	// 특정 양의 쓰레기를 가진 곳의 좌표를 찾는 함수
	static int[] find(int c) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] == c && visited[i][j]==false) {
					// 해당 값을 발견하면 i,j를 리턴해주는데, 방문 확인도 체크해줌.
					visited[i][j] = true;
					return new int[] {i,j};
				}
			}
		}
		return null;
	}
}