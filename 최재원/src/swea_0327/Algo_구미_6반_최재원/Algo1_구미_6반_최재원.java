package samsung01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo1_구미_6반_최재원 {
	static int T, N, minIdx, minIdy, min;
	static int[][] arr, height;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// T를 입력받고, T번동안 반복문을 수행한다.
		T= Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			// N*N 배열을 생성하기 위해 N을 입력받고 arr 배열을 생성한다.
			// 
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			height = new int[N][N];
			for(int i=0; i<N; i++) {
				// 입력을 받아 arr에 저장.
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) 
					arr[i][j] = Integer.parseInt(st.nextToken());
			}
			
			// 각 원소 별 상하좌우 값들의 절댓값의 합을 구해서 height 배열에 저장하는 함수
			check();
			
			// check함수를 수행한 이후, height 배열에서 최소인 값의 index x, y를 구한다.
			min = Integer.MAX_VALUE;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(height[i][j] < min) {
						minIdx = i;
						minIdy = j;
						min = height[i][j];
					}
				}
			}
			// height 배열 중 최소인 값, 그 때의 arr 배열값을 출력한다.
			sb.append("#" + t + " ")
			.append(height[minIdx][minIdy])
			.append(" ")
			.append(arr[minIdx][minIdy])
			.append("\n");
		}
		System.out.println(sb);
	}
	
	// for문을 돌면서 해당 원소의 상하좌우의 다른 값들을 비교하면서 절댓값의 합이 최소인 지점을 찾으려고 했는데,
	// 예시처럼 높이를 해당 원소가 아닌 값으로 설정했을 때 비용이 더 줄어들 수 있음. 그 부분을 생각하지 못했습니다.
	
	static void check() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				// arr 배열의 각 원소를 반복문으로 돌면서,
				// 해당 원소의 행과 열에 속한 다른 원소들과의 절댓값을 h에 더해준다.
				int temp = arr[i][j];
				int min1 = arr[i][j];
				int h = 0;
				int h1 = 0;
				for(int k=0; k<N; k++) {
					h += Math.abs(temp - arr[k][j]);
					h += Math.abs(temp - arr[i][k]);
					// 최소 비용이 같은 경우, 높이가 낮은 값을 출력하기 때문에
					// 각 줄에서 최소인 값을 기준(위에서는 temp) min1으로 재설정. 아래에서 똑같이 수행.
					min1 = Math.min(min1, arr[k][j]);
					min1 = Math.min(min1, arr[i][k]);
				}
				// min1에 대해 h1을 구한다.
				for(int k=0; k<N; k++) {
					h1 += Math.abs(min1 - arr[k][j]);
					h1 += Math.abs(min1 - arr[i][k]);
				}
//				System.out.println(temp + " " + h +"   " + min1+ " "+ h1);
				// height[i][j]에 h와 h1 중 작은 값을 넣어준다.
				height[i][j] = Math.min(h, h1);
			}
		}
	}
}

