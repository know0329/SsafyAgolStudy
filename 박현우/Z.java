package algorithm;

import java.io.*;
import java.util.*;

public class Z {
	static int res = -1;
	static int N,r,c;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());				
	
		z(N,0,0);
	}
	
	static void z(int Num,int row,int col) {
		if(Num == 1) {
			for(int i=row;i<row+2;i++) {
				for(int j=col;j<col+2;j++) {
					res++;
					if(r==i && c==j) System.out.println(res);
				}
			}
			return;
		}
		
		int loop = (int)Math.pow(2, Num);
		int nr = row + loop/2;
		int nc = col + loop/2;
		
		// 범위에 따른 연산순서 주의
		
		if(r < nr && c < nc) {
			z(Num-1,row,col);			
		} else if(r < nr && c >= nc) {
			res += (loop*loop)/4;
			z(Num-1,row,nc);
		} else if(r >= nr && c < nc) {
			res += (loop*loop)/4*2;
			z(Num-1,nr,col);
		} else {
			res += (loop*loop)/4*3;
			z(Num-1,nr,nc);
		}

	}
}

