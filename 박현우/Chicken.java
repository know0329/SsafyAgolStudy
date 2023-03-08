package algorithm;

import java.io.*;
import java.util.*;
import java.awt.Point;

//15686
public class Chicken {
	static int[][] arr;
	static List<Point> p = new ArrayList<>();
	static Point[] chi;
	static int res = 987654321;
	static int n, m;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][n];
		chi = new Point[m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2)
					p.add(new Point(i, j));
			}
		}
		f(0, 0);
		
		System.out.println(res);
	}

	private static void f(int start, int cnt) {
		if (cnt == m) {
			int tres = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] == 1) {
						int tmin = 987654321;
						for(Point c : chi) 
							tmin = tmin > distance(new Point(i, j), c) ? distance(new Point(i, j), c) : tmin;
						tres += tmin;
					}						
				}
			}
			res = res > tres ? tres : res;
			return;
		}

		for (int i = start; i < p.size(); i++) {
			chi[cnt] = p.get(i);
			f(i + 1, cnt + 1);
		}
	}

	private static int distance(Point home, Point chic) {
		return Math.abs(home.y - chic.y) + Math.abs(home.x - chic.x);
	}
}
