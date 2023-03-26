package study_0323;

import java.util.Scanner;

public class dp_1003 {
	static int result0, result1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0; i<T; i++) {
			int N = sc.nextInt();
			result0 = 0;
			result1 = 0;
			fibonacci(N);
			System.out.println(result0 +" " + result1);
		}
	}
	static void fibonacci(int n) {
	    if (n == 0) {
//	        System.out.println("0");
	        result0++;
	    } else if (n == 1) {
//	        System.out.println("1");
	        result1++;
	    } else if(n<0) return;
	    else {
	        fibonacci(n-1);
	        fibonacci(n-2);
	    }
	}
}
