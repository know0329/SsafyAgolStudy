package algorithm;

import java.util.*;
import java.io.*;

public class Main2563
{
    static private int[][] arr = new int[100][100];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int res = 0;
		
		for(int i=0;i<n;i++) {
		    st = new StringTokenizer(br.readLine());
		    int x = Integer.parseInt(st.nextToken());
		    int y = Integer.parseInt(st.nextToken());
		    
		    for(int j=x;j<x+10;j++) {
		        for(int k=y;k<y+10;k++) {
		            arr[k][j] = 1;
		        }
		    }
		}
		
		for(int j=0;j<100;j++) {
		  for(int k=0;k<100;k++) {
		      if(arr[j][k] == 1) res++;
		  }
		}
		System.out.println(res);
	}
}

