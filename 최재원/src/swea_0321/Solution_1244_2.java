package swea_0321;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution_1244_2 {
	static int T, N, max;
	static int[] money;
	static HashSet<String> set;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			money = new int[s.length()];
			N = Integer.parseInt(st.nextToken());
			for(int i=0; i<s.length(); i++) 
				money[i] = s.charAt(i) - '0'; 

			set = new HashSet<>();
			max = 0;
			find(money,N);
			
			sb.append("#" + t + " " + max);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static void find(int[] num, int N) {
		// num 배열을 10진수 숫자로 만들기
		int val = 0;
		
		for (int i = 0; i < num.length; i++) {
			val = val * 10 + num[i];
		}
		
		if(set.contains(""+val+N)) {
			return; // 검토 했던 작업이므로 리턴
		} else {
			set.add(""+val+N); // 현재 상태 저장
		}
		
		if(N == 0) { // 종료파트, 교환회수가 0이면 종료
			if(max < val) max = val;
		} else { // 임의의 2개 숫자를 골라서(조합) 교환
			for(int i=0; i<num.length-1; i++) {
				for (int j = i+1; j < num.length; j++) {
					
					int temp = num[i];
					num[i] = num[j];
					num[j] = temp;
					
					find(num, N-1);
					
					// 원복
					temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}
	}
}
