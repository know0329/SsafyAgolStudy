package study_0302;

import java.util.Scanner;

public class Main_2578 {
	
	static int[][] input = new int[5][5];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<5; i++) 
			for(int j=0; j<5; j++)
				input[i][j] = sc.nextInt();
		
		int cnt = 0;
		while(true) {
			
			int temp = sc.nextInt();
			cnt++;
			for(int i=0; i<5; i++)
				for(int j=0; j<5; j++)
					if(input[i][j] == temp)
						input[i][j] = 0;
			
			int flag = 0;
			if(cnt >= 12) {
				
				// 가로 빙고 확인
				for(int i=0; i<5; i++) {
					int row = input[i][0] + input[i][1] + input[i][2] + input[i][3] + input[i][4];
					if(row == 0) flag++;
				}
				
				// 세로 빙고 확인
				for(int i=0; i<5; i++) {
					int col = input[0][i] + input[1][i] + input[2][i] + input[3][i] + input[4][i];
					if(col == 0) flag++;
				}
				
				// 대각 빙고 확인
				int sum1 = 0;
				int sum2 = 0;
				sum1 = input[0][4] + input[1][3] + input[2][2] + input[3][1] + input[4][0];
				if(sum1 == 0) flag++;
				sum2 = input[0][0] + input[1][1] + input[2][2] + input[3][3] + input[4][4];
				if(sum2 == 0) flag++;
			}
			
			if(flag >= 3) {
				System.out.println(cnt);
				break;
			}
			
		}
	}
}
