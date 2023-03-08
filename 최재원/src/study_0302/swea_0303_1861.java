package study_0302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class swea_0303_1861 {
	
	static int[][] input;
	static int T, N, cnt, result, result_idx;
	static StringBuilder sb = new StringBuilder();
	static int[] id = new int[2];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			result = Integer.MIN_VALUE;
			result_idx = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			input = new int[N+2][N+2];
			for(int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<=N; j++) {
					input[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			ArrayList<int[]> list = new ArrayList<>();
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					cnt = 1;
					int idx = input[i][j];
					dfs(i,j);
					if(cnt >= result) {
						result = cnt ;
						list.add(new int[] {idx,result});
					}
				}
			}
			
			for(int[] l : list) {
				if(l[1] < result) continue;
				else {
					result_idx = Math.min(result_idx, l[0]);
				}
			}
			sb.append("#" + t + " " + result_idx + " " + result + "\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int x, int y) {
		if(input[x+1][y] == input[x][y] + 1) {
			cnt++;
			dfs(x+1,y);
		}else if(input[x-1][y] == input[x][y] + 1) {
			cnt++;
			dfs(x-1,y);
		}else if(input[x][y+1] == input[x][y] + 1) {
			cnt++;
			dfs(x,y+1);
		}else if(input[x][y-1] == input[x][y] + 1) {
			cnt++;
			dfs(x,y-1);
		}
		else return;
	}
	
}
