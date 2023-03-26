package study_0323;

import java.util.Scanner;

public class dp_1463 {
	static int result = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] d = new int[N+3];
        d[1] = d[2] = d[3] = 1;
        
		if(N==1) {
			System.out.println(0); 
		}
		else {
	        for (int i = 4; i <= N; i++) {
	            d[i] = d[i-1] + 1;
	            if (i % 3 == 0) d[i] = Math.min(d[i], d[i/3] + 1);
	            if (i % 2 == 0) d[i] = Math.min(d[i], d[i/2] + 1);
	        }
	        System.out.println(d[N]);
		}
		sc.close();
	}
//	static void dp(int n) {
//		if(n==1) return;
//		if(n%3 == 0) {
//			n /= 3;
//			result++;
//			dp(n);
//		}else if(n%3 == 1) {
//			n--;
//			n /= 3;
//			result += 2;
//			dp(n);
//		}else if(n%2 == 0) {
//			n /= 2;
//			result++;
//			dp(n);
//		}else {
//			n--;
//			result++;
//			dp(n);
//		}
//		
//	}
}
