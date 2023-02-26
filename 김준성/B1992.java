import java.util.*;
import java.io.*;

public class B1992
{
	static int [][] arr;
	static StringBuilder sb;
	static void rec(int x, int y, int size) {
		boolean check = true; 
		int checkingValue = arr[x][y];
		for(int i = x; i < x+ size; i++) {
			for(int j = y; j < y+ size; j++) {
				if(arr[i][j] != checkingValue) {
					check = false;
				}
			}
			if(!check)
				break;
		}
		if(check) {
			sb.append(checkingValue);
			return;
		}
		else {
			sb.append('(');
			rec(x, y, size/2);
			rec(x, y+size/2, size/2);
			rec(x + size/2, y, size/2);
			rec(x+size/2, y + size/2, size/2);
			sb.append(')');
		}
	}
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String num = st.nextToken();
			for(int j = 0; j < N; j++) {				
				arr[i][j] = num.charAt(j) - '0';
			}
		}
		rec(0, 0, N);
		System.out.println(sb.toString());
	}
}