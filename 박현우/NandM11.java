package algorithm;

import java.io.*;
import java.util.*;

public class NandM11 {
	static int n, m;
	static int[] arr;
	static int[] str;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		str = new int[m];
		
		st = new StringTokenizer(br.readLine());
		
        for (int i = 0; i < n; i++) 
            arr[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(arr);
		
		f(0);
		
		System.out.println(sb);
	}
	
	static void f(int cur) {
	    int pre = -1;
		if(cur == m) {
		    for(int i=0; i<m; i++) 
                sb.append(str[i] + " ");
			sb.append(System.getProperty("line.separator"));
			return;
		}
		
		for(int i=0; i<n; i++) {
		    if(pre == arr[i]) continue;
		    pre = arr[i];
            str[cur] = arr[i];
			f(cur+1);
		}
		
	}
}
