package algorithm;
import java.io.*;
import java.util.*;

public class NandM {
	static int n, m;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		f(0,"");
		
		System.out.println(sb);
	}
	
	static void f(int cur,String st) throws Exception{
		if(cur == m) {
			sb.append(st);
			sb.append(System.getProperty("line.separator"));
			return;
		}
		
		for(int i=1; i<=n; i++) {
			String temp = st + (i + " ");
			f(cur+1, temp);
		}
		
	}
}
