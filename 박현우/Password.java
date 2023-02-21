package algorithm;
import java.io.*;
import java.util.*;

public class Password {
	static int l, c;
	static char[] alpha;
	static boolean[] v;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		alpha = new char[c];
		v = new boolean[c];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<c; i++)
			alpha[i] = st.nextToken().charAt(0);
		
		Arrays.sort(alpha);
		
		f(0,0,0,"");
		
		System.out.println(sb);
	}
	
	static void f(int st, int cur, int mo, String ans) throws Exception{
		if(cur == l) {
			if((l-mo) >= 2 && mo >= 1)
				sb.append(ans + "\n");
			return;
		}
		
		int nmo = mo;
		
		for(int i=st;i<c;i++) {
			if(v[i]) continue;
			v[i] = true;
			
			if(alpha[i] == 'a' || alpha[i] == 'i' || alpha[i] == 'e' || alpha[i] == 'o' || alpha[i] == 'u')
				f(i+1,cur+1,nmo+1,ans+alpha[i]);
			else
				f(i+1,cur+1,nmo,ans+alpha[i]);
			
			v[i] = false;
		}
		
	}
}
