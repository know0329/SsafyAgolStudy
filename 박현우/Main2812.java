package algorithm;

import java.io.*;
import java.util.*;

public class Main2812 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, k;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		int fin = n-k;
		String num = br.readLine();
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0;i<n;i++) {
			while(!stack.isEmpty() && stack.peek() < num.charAt(i) && k > 0) {
				stack.pop();
				k--;
			}
			stack.add(num.charAt(i));
		}
		StringBuffer sb = new StringBuffer();
		while(!stack.isEmpty()) sb.append(stack.pop());
		
		System.out.println(sb.reverse().toString().substring(0, fin));
	}
}