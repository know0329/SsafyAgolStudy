package swea_0320;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1240 {

	static int T, N, M;
	static String inputStr;
	static char[] input;
	static int[] output;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int flag = -1;
			for(int i=0; i<N; i++) {
				input = new char[M+1];
				String str = br.readLine();
				for(int j=0; j<M; j++) {
					input[j] = str.charAt(j);
				}
				if(isCode(input) == false) continue;
				else {
					inputStr = "";
					toCode(input);
					flag = solve(inputStr);
				}
//				if(flag != -1) break;
			}
			if(flag == -1) {
				sb.append("#"+t +" 0").append("\n");
			}else sb.append("#"+t +" " + flag).append("\n");
		}
		System.out.println(sb);
	}
	
	static boolean isCode(char[] input) {
		for(int i=0; i<input.length; i++) {
			if(input[i] == '1') return true;
			else continue;
		}
		return false;
	}
	static void toCode(char[] input) {
		String str = "0";
		for(int i=0; i<M; i++) {
			if(input[i] == '1') {
				if(input[i+54]=='0' && input[i+53]=='0') str += "00";
				else if(input[i+54]=='0' && input[i+53]!='0') str += "0";
				
				for(int j=0; j<55; j++) {
					str += input[i+j];
				}
				inputStr = str;
				return;
			} else continue;
		}
	}
	static int solve(String str) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<8; i++) {
			String sub = str.substring(i*7, i*7+7);
//			System.out.println(sub);
			if(sub.equals("0001101")) list.add(0);
			else if(sub.equals("0011001")) list.add(1);
			else if(sub.equals("0010011")) list.add(2);
			else if(sub.equals("0111101")) list.add(3);
			else if(sub.equals("0100011")) list.add(4);
			else if(sub.equals("0110001")) list.add(5);
			else if(sub.equals("0101111")) list.add(6);
			else if(sub.equals("0111011")) list.add(7);
			else if(sub.equals("0110111")) list.add(8);
			else if(sub.equals("0001011")) list.add(9);
		}
		int sum_odd = 0;
		int sum_even = 0;
		for(int i=0; i<list.size(); i++) {
			if(i%2 == 1) sum_even += list.get(i);
			else sum_odd += list.get(i);
		}
		if((sum_odd * 3 + sum_even) % 10 == 0) return sum_odd + sum_even;
		else return 0;
	}
}
