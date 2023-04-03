package study_0330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1629 {
	
	static long A, B, C;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());
		
		long result = calc(A,B,C);
		System.out.println(result);
	}
	static long calc(long a, long b, long c) {
		// return a도 %c 해주어야 함.
		if(b==1) return a % c;
		
		long temp = calc(a, b/2, c) % c;
		
		if(b%2 == 0) 
			return temp * temp % c;
		else 
			// temp * temp 다음, %c 해주어야 long 범위 안 벗어남.
			return (temp * temp % c) * a % c;
	}
}