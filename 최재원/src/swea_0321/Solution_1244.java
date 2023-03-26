package swea_0321;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_1244 {
	static int T, N;
	static String M;
	static int[] money;
	static Integer[] moneySort;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = st.nextToken();
			money = new int[M.length()];
			moneySort = new Integer[M.length()];
			N = Integer.parseInt(st.nextToken());
			for(int i=0; i<M.length(); i++) {
				money[i] = M.charAt(i) - '0'; 
				moneySort[i] = money[i];
			}
			Arrays.sort(moneySort, Collections.reverseOrder());
			sb.append("#" + t + " ");
			sort(0,0);
		}
		System.out.println(sb);
	}
	
	static void sort(int depth, int start) {
		if(depth == N) {
			for(int i=0; i<money.length; i++) 
				sb.append(money[i]);
			sb.append("\n");
			return;
		}
		
		if(isSorted()) {
			int hasSameNumber = hasSameNum();
			if(hasSameNumber == -1) {
				int temp = money[money.length-1];
				money[money.length-1] = money[money.length-2];
				money[money.length-2] = temp;
				sort(depth+1, start+1);
			}
			else sort(depth+1, start+1);
		} else {
			int idx = -1;
			int min_idx = -1;
			int min = money[0];
			for(int i=start; i<money.length; i++) {
				if(money[i] == moneySort[i]) continue;
				else {
					for(int j=i; j<money.length; j++) {
						if(money[j] == moneySort[i]) idx = j;
						if(money[j] < min) {
							min_idx = j;
							min = money[j];
						}
					}
					int temp = money[i];
					money[i] = money[idx];
					money[idx] = temp;
					break;
				}
			}
			sort(depth+1, start+1);
		}
	}
	static boolean isSorted() {
		for(int i=0; i<money.length; i++) {
			if(money[i] == moneySort[i]) continue;
			else return false;
		}
		return true;
	}
	static int hasSameNum() {
		int max = -1;
		for(int i=0; i<money.length; i++) {
			if(max == money[i]) return i;
			else {
				max = money[i];
			}
		}
		return -1;
	}
}
