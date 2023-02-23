package algorithm;
import java.io.*;
import java.util.*;
//1992
public class QuardTree {
	static StringBuilder sb = new StringBuilder();
	static char[][] tree;
 	static int n;
 	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		tree = new char[n][n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			String t = st.nextToken();
			for(int j=0;j<n;j++)
				tree[i][j] = t.charAt(j);
		}
		
		f(0, 0, n);
		
		System.out.println(sb);
	}
	
	static void f(int i,int j,int size) {
		if(size == 1) {
			sb.append(tree[i][j]);
			return;
		}
		
		int temp = tree[i][j];
		boolean go = false;
		
		for(int k=i;k<i+size;k++) {
			for(int l=j;l<j+size;l++) {
				if(temp != tree[k][l]) {
					go = true;
					break;
				}
			}
		}
		
		if(go) {
			int nSize = size/2;
			
			sb.append("(");
			f(i,j,nSize);
			f(i,j+nSize,nSize);
			f(i+nSize,j,nSize);
			f(i+nSize,j+nSize,nSize);
			sb.append(")");			
		} else {
			sb.append(temp-'0');
			return;
		}
	}
}
