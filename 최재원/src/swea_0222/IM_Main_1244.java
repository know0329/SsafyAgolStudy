package swea_0222;

import java.util.Scanner;

public class IM_Main_1244 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int len = sc.nextInt();
		int[] input = new int[len];
		for(int i=0; i<len; i++) {
			input[i] = sc.nextInt();
		}
		
		int stu = sc.nextInt();
		for(int i=0; i<stu; i++) {
			int gender = sc.nextInt();
			int get = sc.nextInt();
			
			if(gender == 1) {
				for(int j=1; j<=len; j++) {
					if(get*j <= len) {
						if(input[get*j - 1] == 0) input[get*j - 1] = 1;
						else input[get*j - 1] = 0;
					}
				}
			}else {
				if(get == 1) {
					if(input[0] == 1) input[0] = 0;
					else input[0] = 1;
					continue;
				}
				// 부여받은 수의 스위치 변경.
				if(input[get-1] == 0) input[get-1] = 1;
				else input[get-1] = 0;
				// 대칭 확인 후 변경.
				int left = get-1-1;
				int right = get-1+1;
				
				while(left >= 0 && right < len) {
					if(input[left] == input[right]) {
						if(input[left] == 0) {
							input[left] = 1;
							input[right] = 1;
						}else {
							input[left] = 0;
							input[right] = 0;
						}
						left--;
						right++;
					}else break;
				}
			}
			
		}
		for(int t=0; t<len; t++) {
			if(t != 0 && t%20 == 0) sb.append("\n");
			sb.append(input[t] + " ");
		}
		System.out.print(sb);
		sc.close();
	}
}
