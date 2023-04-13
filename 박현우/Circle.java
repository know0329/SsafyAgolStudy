package algorithm;

import java.io.*;
import java.util.*;

public class Circle {
	static char[][] circle;
	static int res, k, cur, dir;
	static boolean[] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		circle = new char[4][8];
		
		for(int i=0;i<4;i++) {
			String s = br.readLine();
			for(int j=0;j<8;j++) circle[i][j] = s.charAt(j);
		}
		
		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		
		// 회전
		for(int i=0;i<k;i++) {
			st = new StringTokenizer(br.readLine());
			cur = Integer.parseInt(st.nextToken());
			dir = Integer.parseInt(st.nextToken());
			
			// 회전
			v = new boolean[4];
			rot(cur-1, dir);
		}
		score();

		System.out.println(res);
	}
	// 시계방향 회전 -> 포인터가 -1 <> 반시계방향 회전 -> 포인터가 +1
	private static void rot(int cur, int dir) {
		if(v[cur]) return;
		v[cur] = true;
		int left = cur - 1;
		int right = cur + 1;
		if(left >= 0 && left <= 3 && circle[cur][6] != circle[left][2]) rot(left,-1*dir);
		if(right >= 0 && right <= 3  && circle[cur][2] != circle[right][6]) rot(right,-1*dir);
		
		// 본인회전 (시계 - 반시계)
		if(dir == 1) {
			char first = circle[cur][7];
			for(int i=7;i>0;i--) circle[cur][i] = circle[cur][i-1]; 
			circle[cur][0] = first;
		}
		else {
			char first = circle[cur][0];
			for(int i=0;i<7;i++) circle[cur][i] = circle[cur][i+1]; 
			circle[cur][7] = first;			
		}
	}
	//S 극이 1
	private static void score() {
		res = 0;
		if(circle[0][0] == '1') res += 1;
		if(circle[1][0] == '1') res += 2;
		if(circle[2][0] == '1') res += 4;
		if(circle[3][0] == '1') res += 8;
	}
}

