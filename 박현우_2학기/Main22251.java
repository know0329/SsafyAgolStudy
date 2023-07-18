import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] num = {
			{1,1,1,1,1,1,0}, 
			{0,0,1,1,0,0,0},
			{0,1,1,0,1,1,1},
			{0,1,1,1,1,0,1},
			{1,0,1,1,0,0,1},
			{1,1,0,1,1,0,1},
			{1,1,0,1,1,1,1},
			{0,1,1,1,0,0,0},
			{1,1,1,1,1,1,1},
			{1,1,1,1,1,0,1}
	};
	public static void main(String[] args) throws IOException {
		int answer = 0;
		st = new StringTokenizer(br.readLine());
				
		Integer n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		String x = st.nextToken();
		
		if(k > n.toString().length()) {
			System.out.println(answer);
			return;
		}
		
		for(Integer i=1;i<=n;i++) {
			String rn = i.toString();

			// 길이를 k로 맞추기
			rn = concat(rn, k);
			x = concat(x, k);
			
			// 변경에 필요한 연산 수 체크
			if(chk(rn, x, k, p)) answer++;
		}
		
		System.out.println(answer-1); // 자기자신 제외
	}
	
	private static String concat(String s, int len) {
		String temp = s;
		while(temp.length() < len) temp = "0" + temp;
		return temp;
	}
	
	private static boolean chk(String aft, String cur, int len, int fin) {
		int cnt = 0;
		for(int i=0;i<len;i++) {
			int af = aft.charAt(i) - '0';
			int cu = cur.charAt(i) - '0';

			for(int j=0;j<7;j++) 
				if(num[af][j] != num[cu][j]) cnt++;			
			
		}

		if(cnt <= fin) return true;
		return false;
	}
}