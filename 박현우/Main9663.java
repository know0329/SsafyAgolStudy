package algorithm;

import java.io.*;
import java.util.*;

public class Main9663 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, res;
	static boolean row[];
	static boolean col[];
	static boolean right[];
	static boolean left[];

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());

		row = new boolean[n];
		col = new boolean[n];
		right = new boolean[2 * n - 1];
		left = new boolean[2 * n - 1];

		// n*n 중 한 곳에 놓는다
		f(0, 0);

		System.out.println(res);
	}

	private static void f(int y, int cnt) {
		if (cnt == n) {
			res++;
			return;
		}
		if(y >= n) return;
		
		// 어느 칸에 둘지 고른다 (한줄에 하나만 놓을 수 있으므로 안 놓는 경우에 함수 호출을 줄인다)
		for(int x=0;x<n;x++) {
			// 놓을 수 있는 자리를 탐색하면서 놓고 바로 다음줄로
			if (!row[y] && !col[x] && !left[y + x] && !right[y - x + n - 1]) {
				row[y] = col[x] = left[y + x] = right[y - x + n - 1] = true;
				f(y+1, cnt + 1); // 놓는다
				row[y] = col[x] = left[y + x] = right[y - x + n - 1] = false;
			}			
		}	
	}

}