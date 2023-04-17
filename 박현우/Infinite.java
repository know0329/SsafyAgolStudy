package algorithm;

import java.io.*;
import java.util.*;

public class Infinite {
	static long n, p, q, res;
	static HashMap<Long,Long> map = new HashMap<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Long.parseLong(st.nextToken());
		p = Long.parseLong(st.nextToken());
		q = Long.parseLong(st.nextToken());
			
		System.out.println(f(n));
	}
	
	private static long f(long cur) {
		if(cur == 0) return 1;
		if(map.get(cur/p) == null) map.put(cur/p,f(cur/p));
		if(map.get(cur/q) == null) map.put(cur/q,f(cur/q));
		return map.get(cur/p) + map.get(cur/q);
	}
}

