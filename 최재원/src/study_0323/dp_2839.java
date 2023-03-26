package study_0323;

import java.util.Scanner;

public class dp_2839 {
	static int result = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		if(N==4 || N==7) result = -1;
		else if(N%5==0) result = N/5;
		else if(N%5==1 || N%5==3) result = N/5 + 1;
		else if(N%5==2 || N%5==4) result = N/5 + 2;
		
		System.out.println(result);
		sc.close();
	}
	
}
