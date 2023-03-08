package study_0309;

import java.util.Scanner;

public class Main_0309_2007년 {

	static int x, y, date;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		y = sc.nextInt();
		date = y;

		if(x == 1) {
			date += 0;
		}else if(x == 2) {
			date += 31; 	// 1월 거 더하기.
		}else if(x == 3) {
			date += 31 + 28;
		}else if(x == 4) {
			date += 31 + 28 + 31;
		}else if(x == 5) {
			date += 31 + 28 + 31 + 30;
		}else if(x == 6) {
			date += 31 + 28 + 31 + 30 + 31;
		}else if(x == 7) {
			date += 31 + 28 + 31 + 30 + 31 + 30;
		}else if(x == 8) {
			date += 31 + 28 + 31 + 30 + 31 + 30 + 31;
		}else if(x == 9) {
			date += 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31;
		}else if(x == 10) {
			date += 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30;
		}else if(x == 11) {
			date += 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31;
		}else if(x == 12) {
			date += 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30;
		}
		
		if(date%7 == 1) System.out.println("MON");
		else if(date%7 == 2) System.out.println("TUE");
		else if(date%7 == 3) System.out.println("WED");
		else if(date%7 == 4) System.out.println("THU");
		else if(date%7 == 5) System.out.println("FRI");
		else if(date%7 == 6) System.out.println("SAT");
		else if(date%7 == 0) System.out.println("SUN");

		sc.close();
	}
	
	
}
