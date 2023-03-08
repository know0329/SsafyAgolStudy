package study_0302;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_15686 {
	
	static int N, M, Chi, result;
	static int[][] input;
	static int[] xy;
	static List<Integer> X = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		Chi = 0;
		xy = new int[M];
		input = new int[N+1][N+1];
		result = Integer.MAX_VALUE;
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				input[i][j] = sc.nextInt();
				if(input[i][j] == 2) {
					Chi++;
					X.add(N*(i-1)+j);
				}
			}
		}
		Comb(0,0);
		System.out.println(result);
		sc.close();
	}
	static int[] visit;
	static void Comb(int cnt, int start) {
		if(cnt == M) {
			visit = new int[(N+1)*(N+1)];
			for(int i=0; i<M; i++) {
				if(visit[xy[i]] == 1) return;
				else visit[xy[i]] = 1;
			}

			int[][] arr = new int[M][2];
			
			int cal_dis = 0;
			for(int k=1; k<=N; k++) {
				for(int j=1; j<=N; j++) {
					if(input[k][j] == 1) {
						int min = Integer.MAX_VALUE;
						int distance = 0;
						for(int i=0; i<M; i++) {
							arr[i][0] = xy[i] / N + 1; 
							arr[i][1] = xy[i] % N;
							if(arr[i][0] > N) arr[i][0] = N;
							if(arr[i][1] == 0) arr[i][1] = N;

							distance = Math.abs(k - arr[i][0]) + Math.abs(j - arr[i][1]);
							if(min >= distance) min = distance;
						}
						cal_dis += min;
					}
				}
			}
			if(result >= cal_dis) result = cal_dis;
			
			return;
			
		}else {
			for(int i=start; i<Chi; i++) {
				xy[cnt] = X.get(i);
				Comb(cnt+1,start+1);
			}
		}
	}
}
