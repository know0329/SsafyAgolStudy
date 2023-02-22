package swea_0222;

import java.util.Scanner;

public class IM_Main_2669 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = -1;
		int result = 0;
		int[][] input = new int[4][4];
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				input[i][j] = sc.nextInt();
				if(input[i][j] >= max) max = input[i][j];
			}
		}
		
		int[][] output = new int[max][max];
		for(int i=0; i<4; i++) {
			int x1 = input[i][0];
			int y1 = input[i][1];
			int x2 = input[i][2];
			int y2 = input[i][3];
			int dx = x2 - x1;
			int dy = y2 - y1;
			
			for(int j=0; j<dx; j++) {
				for(int k=0; k<dy; k++) {
					if(output[x1 + j][y1 + k] == 0)
						output[x1+j][y1+k] = 1;
				}
			}
		}
		for(int i=0; i<max; i++) {
			for(int j=0; j<max; j++) {
				if(output[i][j] == 1) result++;
			}
		}

		System.out.println(result);
		
		sc.close();
	}
}
