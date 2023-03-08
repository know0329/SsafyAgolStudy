package algorithm;

import java.io.*;
import java.util.*;

public class TwoThousand {
	static int n, m;
	static int[] month = new int[13];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
				
		// 월별 누적일수를 구한다.
		f();
		// 0(일요일) ~ 6(토요일)
		System.out.println(day((month[n] + m) % 7));
	}
	
	//1, 3, 5, 7, 8, 10,  31, 4, 6, 9, 30일, 2월은 28일
	private static void f() {
		month[1] = 0; // 1월 누적일수 0일
		month[2] = 31; // 2월 누적일수 31일
		
		for(int i=1;i<=11;i++) {
			if(i == 2) month[i+1] = month[i] + 28;  
			else if(i == 4 || i == 6 || i == 9 || i == 11) month[i+1] = month[i] + 30;
			else month[i+1] = month[i] + 31;
		}
	}
	
	private static String day(int cur) {
		if(cur == 1) return "MON";
		else if(cur == 2) return "TUE";
		else if(cur == 3) return "WED";
		else if(cur == 4) return "THU";
		else if(cur == 5) return "FRI";
		else if(cur == 6) return "SAT";
		else return "SUN";
	}
}
