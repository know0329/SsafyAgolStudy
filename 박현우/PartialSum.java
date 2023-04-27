package algorithm;

import java.io.*;
import java.util.*;

public class PartialSum {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, s, res=100_000_000;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());

		arr = new int[n + 1];

		st = new StringTokenizer(br.readLine());

		// 누적합을 저장한다.
		for (int i = 0; i < n; i++)
			arr[i + 1] = arr[i] + Integer.parseInt(st.nextToken());

		// 수열로 누적합 s을 만드는 것이 불가능 할 때
		if (arr[n] < s) {
			System.out.println(0);
			return;
		}

		int start = 0;
		// 투포인터
		for (int end = 1; end <= n; end++) {
			if(arr[end]-arr[start] >= s) {
				while(arr[end] - arr[start++] >= s) {}
				start--;
				System.out.println(end + " " + start);
				res = Math.min(res, end-start+1);
			}
		}

		System.out.println(res);
	}
}