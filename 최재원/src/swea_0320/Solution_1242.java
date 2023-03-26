package swea_0320;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1242 {
	static int T, N, M;
	static String str;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			for(int i=0; i<N; i++) {
				str = br.readLine();
				str = str.replaceAll("0", "");
				if(str.length() != 0) continue;
			}
			
			toBinaryCode(str);
			
//			System.out.println(str);
		}
	}
	static void toBinaryCode(String str) {
		String bCode = "";
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == '1') str += "0001101";
			else if(str.charAt(i) == '2') str += "0011001";
			else if(str.charAt(i) == '3') str += "0010011";
			else if(str.charAt(i) == '4') str += "0111101";
			else if(str.charAt(i) == '5') str += "0100011";
			else if(str.charAt(i) == '6') str += "0110001";
			else if(str.charAt(i) == '7') str += "0101111";
			else if(str.charAt(i) == '8') str += "0111011";
			else if(str.charAt(i) == '9') str += "0001011";
			else if(str.charAt(i) == 'A') str += "";
			else if(str.charAt(i) == 'B') str += "";
			else if(str.charAt(i) == 'C') str += "";
			else if(str.charAt(i) == 'D') str += "";
			else if(str.charAt(i) == 'E') str += "";
			else if(str.charAt(i) == 'F') str += "";
		}
	}
}
