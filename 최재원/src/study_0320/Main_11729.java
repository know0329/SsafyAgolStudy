package study_0320;

import java.util.Scanner;

public class Main_11729 {
	static int cnt;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		cnt = 0;
		hanoi(N, 1, 2, 3);
		System.out.println(cnt);
		System.out.println(sb);
		sc.close();
	}
	static void hanoi(int num, int start, int mid, int to) {
		cnt++;
		if(num == 1) {
			sb.append(start + " " + to + "\n");
			return;
		}
		hanoi(num-1,start, to, mid);
		sb.append(start + " " + to + "\n");
		hanoi(num-1,mid,start,to);
	}
}
