package algorithm;

import java.io.*;
import java.util.*;

//일반 순열

public class NandM5 {
	static int n, m;
	static int[] arr;
	static int[] buf;
	static boolean[] v;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		buf = new int[m];
		v = new boolean[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) 
			arr[i] = Integer.parseInt(st.nextToken());
				
		Arrays.sort(arr);
		
		f(0);

		System.out.println(sb);
	}
	
	private static void f(int cnt) {
		if(cnt == m) {
			for(int i=0;i<m;i++) sb.append(buf[i] + " ");
			sb.append("\n");
			return;
		}

		for(int i=0;i<n;i++) {
			if(v[i] == true) continue;
			buf[cnt] = arr[i];
			
			v[i] = true;
			f(cnt+1);
			v[i] = false;
		}
	}
	
}
