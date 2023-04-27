package algorithm;

import java.awt.Point;
import java.io.*;
import java.util.*;

//https://melthleeth.tistory.com/entry/%EB%B0%B1%EC%A4%80-1939-%EC%A4%91%EB%9F%89%EC%A0%9C%ED%95%9C-Java
public class Main1939 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m, c, res;
	static int start, end;
	static int[] v;
	static ArrayList<Point>[] island;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		island = new ArrayList[n+1];
        v = new int[n+1];
		
		for(int i=0;i<=n;i++) island[i] = new ArrayList<>();

		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			// 양방향
			island[from].add(new Point(weight, to));
			island[to].add(new Point(weight, from));
		}
		// 정렬 or pq 써도됨
        for(int i=0;i<=n;i++) {
			if(island[i].size() > 1) Collections.sort(island[i],new Comparator<Point>() {
				public int compare(Point a, Point b) {
					return b.x-a.x;
				}
			});
		}
        
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		Queue<Point> q = new LinkedList<>(); 
		
		q.add(new Point(1000_000_001,start));
		v[start] = 1000_000_001;
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
            int from = cur.y;
            int weight = cur.x;
            if(weight < v[from]) continue; // 53%에서 메모리초과(시간초과)를 방지하려면 필요함 for문전에 한번 쳐내주는 과정
            
			for(int i=0;i<island[from].size();i++) {
				int to = island[from].get(i).y;
				int weightTo = Math.min(weight,island[from].get(i).x);
				if(weightTo <= v[to]) continue;
				v[to] = weightTo;
				q.add(new Point(weightTo,to));
			}
		}
		
		System.out.println(v[end]);
	}
}