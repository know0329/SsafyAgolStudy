package algorithm;

import java.util.*;
import java.io.*;

public class OneTwoThree
{
    static private int res;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<t;i++) {
		    st = new StringTokenizer(br.readLine());
		    int x = Integer.parseInt(st.nextToken());
		    res = 0;
		    
		    f(0, x);
		    
		    System.out.println(res);
		}
		
	}
	
	private static void f(int acc, int fin) {
	    if(fin <= acc) {
	        if(fin == acc) res++;
	        return;
	    }
	    
	    for(int i=1;i<=3;i++) {
	        f(acc+i,fin);
	    }
	    
	}
}
