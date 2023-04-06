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
		// T�� �Է¹ް�, T������ �ݺ����� �����Ѵ�.
		T= Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			// N*N �迭�� �����ϱ� ���� N�� �Է¹ް� arr �迭�� �����Ѵ�.
			// 
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			height = new int[N][N];
			for(int i=0; i<N; i++) {
				// �Է��� �޾� arr�� ����.
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) 
					arr[i][j] = Integer.parseInt(st.nextToken());
			}
			
			// �� ���� �� �����¿� ������ ������ ���� ���ؼ� height �迭�� �����ϴ� �Լ�
			check();
			
			// check�Լ��� ������ ����, height �迭���� �ּ��� ���� index x, y�� ���Ѵ�.
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
			// height �迭 �� �ּ��� ��, �� ���� arr �迭���� ����Ѵ�.
			sb.append("#" + t + " ")
			.append(height[minIdx][minIdy])
			.append(" ")
			.append(arr[minIdx][minIdy])
			.append("\n");
		}
		System.out.println(sb);
	}
	
	// for���� ���鼭 �ش� ������ �����¿��� �ٸ� ������ ���ϸ鼭 ������ ���� �ּ��� ������ ã������ �ߴµ�,
	// ����ó�� ���̸� �ش� ���Ұ� �ƴ� ������ �������� �� ����� �� �پ�� �� ����. �� �κ��� �������� ���߽��ϴ�.
	
	static void check() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				// arr �迭�� �� ���Ҹ� �ݺ������� ���鼭,
				// �ش� ������ ��� ���� ���� �ٸ� ���ҵ���� ������ h�� �����ش�.
				int temp = arr[i][j];
				int min1 = arr[i][j];
				int h = 0;
				int h1 = 0;
				for(int k=0; k<N; k++) {
					h += Math.abs(temp - arr[k][j]);
					h += Math.abs(temp - arr[i][k]);
					// �ּ� ����� ���� ���, ���̰� ���� ���� ����ϱ� ������
					// �� �ٿ��� �ּ��� ���� ����(�������� temp) min1���� �缳��. �Ʒ����� �Ȱ��� ����.
					min1 = Math.min(min1, arr[k][j]);
					min1 = Math.min(min1, arr[i][k]);
				}
				// min1�� ���� h1�� ���Ѵ�.
				for(int k=0; k<N; k++) {
					h1 += Math.abs(min1 - arr[k][j]);
					h1 += Math.abs(min1 - arr[i][k]);
				}
//				System.out.println(temp + " " + h +"   " + min1+ " "+ h1);
				// height[i][j]�� h�� h1 �� ���� ���� �־��ش�.
				height[i][j] = Math.min(h, h1);
			}
		}
	}
}

