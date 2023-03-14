package algorithm;

import java.io.*;
import java.util.*;

public class Star10 {
	static int n;
	static char[][] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		arr = new char[n][n];
		
		for(int i=0;i<n;i++) 
			for(int j=0;j<n;j++) 
				arr[i][j] = ' ';
			

		
		f(0,0,n);
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb);
			
	}
	
	private static void f(int r, int c, int s) {
		if(s == 1) {
			arr[r][c] = '*'; 
			return;
		}
		
		int ns = s/3;
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(i == 1 && j == 1) continue;
				f(r + i*ns, c + j*ns, ns);
			}
		}
	}
	
}