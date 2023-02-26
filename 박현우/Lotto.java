package algorithm;
import java.io.*;
import java.util.*;
//6603
public class Lotto {
	static int k = -1;
	static StringBuilder sb = new StringBuilder();
	static int[] lot;
	static int[] temp;
	static boolean[] v;
 	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if(k == 0) break;
			lot = new int[k];
			v = new boolean[k];
			temp = new int[k];
			
			for(int i=0;i<k;i++)
				lot[i] = Integer.parseInt(st.nextToken());
			
			f(0, 0);
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void f(int st, int cur) throws Exception{
		if(cur == 6) {
			for(int i=0;i<6;i++)
				sb.append(temp[i] + " ");
			sb.append("\n");
			return;
		}
		
		for(int i=st; i<k; i++) {
			if(v[i]) continue;
			v[i] = true;
			temp[cur] = lot[i]; 
			f(i+1, cur+1);
			v[i] = false;
		}
		return;
	}
}
