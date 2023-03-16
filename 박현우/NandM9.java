package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NandM9 {
	static int n,m; 
	static int[] arr;
	static int[] buf;
	static boolean[] v;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
			
		arr = new int[n];
		buf = new int[n];
		v = new boolean[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++)
			arr[i] = Integer.parseInt(st.nextToken());
			
		Arrays.sort(arr);
			
		f(0);
		
		System.out.print(sb);
	}
	
	private static void f(int cnt) {
		if(cnt == m) {
			for(int i=0;i<m;i++)
				sb.append(buf[i] + " ");
			sb.append("\n");
			return;
		}
		
		int prev = -1;
		
		for(int i=0;i<n;i++) {
			if(prev == arr[i] || v[i]) continue;
			v[i] = true;
			prev = arr[i];
			buf[cnt] = arr[i];
			f(cnt+1);
			v[i] = false;
		}
	}

}
