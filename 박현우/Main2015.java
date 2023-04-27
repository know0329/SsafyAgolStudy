package algorithm;

import java.io.*;
import java.util.*;

public class Main2015 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static long res;
	static int n, k;
	static long[] arr;
	static HashMap<Long,Long> acc = new HashMap<>(); // N입력이 20만개 이므로 최대 key 조합은 40만개(n,n-k)

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arr = new long[n+1]; // 최대 20만+1개

		st = new StringTokenizer(br.readLine());
		acc.put(0l, 1l); // arr[0] = 0 으로 본다. 
		for(int i=1;i<=n;i++) {
			arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
			// 결과에 현재 누적값 - k(target) 인덱스의 acc 값을 더한다 (k를 만들 수 있는 수가 그만큼 있다는 뜻)
			res += acc.getOrDefault(arr[i]-k,0l);
			// 현재 누적값을 key로 가지는 acc 값을 1 증가
			acc.put(arr[i], acc.getOrDefault(arr[i],0l)+1l);
		}

		System.out.println(res);
	}
}