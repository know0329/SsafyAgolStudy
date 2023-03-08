package study_0302;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_2477 {
	
	static int[][] arr = new int[1000][1000];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		
		int E = 0;	// 동, 1
		int W = 0;	// 서, 2
		int S = 0;	// 남, 3
		int N = 0;	// 북, 4
		
		List<Integer> arr_E = new ArrayList<>();
		List<Integer> arr_W = new ArrayList<>();
		List<Integer> arr_S = new ArrayList<>();
		List<Integer> arr_N = new ArrayList<>();
		
		while(true) {
			int dir = sc.nextInt();
			int len = sc.nextInt();
			
			if( dir == 1 ) {
				arr_E.add(len);
			}
			else if( dir == 2 ) {
				arr_W.add(len);
			}
			
			if( dir == 3 ) {
				arr_S.add(len);
			}
			else if( dir == 4 ) {
				arr_N.add(len);
			}
			
			if(arr_E.size() + arr_W.size() + arr_S.size() + arr_N.size() == 6) break;
		}
		
		int result = 0;
		for(int i=0; i<arr_E.size(); i++) {
			for(int j=0; j<arr_W.size(); j++) {
				result += arr_E.get(i) * arr_W.get(j);
			}
		}
		for(int i=0; i<arr_S.size(); i++) {
			for(int j=0; j<arr_N.size(); j++) {
				result += arr_S.get(i) * arr_N.get(j);
			}
		}
		System.out.println(result);
		
		int max_g = 0;
		int max_s = 0;
		
		if(arr_E.size() == 1) {
			max_g = arr_E.get(0);
		}else {
			max_g = arr_W.get(0);
		}
		
		if(arr_S.size() == 1) {
			max_s = arr_S.get(0);
		}else {
			max_s = arr_N.get(0);
		}
		
		System.out.println(max_g * max_s);
		
		result -= max_g * max_s * 3;
		result *= K;
		System.out.println(result);
		
	}
}
