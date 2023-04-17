package algorithm;

import java.io.*;
import java.util.*;

// -1, +1 하면서 누를 수 있는지 확인
public class Remocon {
	static int n, m, res;
	static boolean[] btn = new boolean[10];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int plus = n, minus = n;
		
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		if(m != 0) {
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<m;i++) {
				int temp = Integer.parseInt(st.nextToken());
				btn[temp] = true; 
			}
		}
		
		while(true) {
			// 누를 수 있는 번호는 0 ~ 무한대<<< 까지 but 최대 500_000 까지 타겟이므로 res가 500_000을 넘어가면 그냥 +,-로 가야함
			if(plus <= 1000_000) {
				if(possible(plus)) break;				
			}
			if(minus >= 0) {
				if(possible(minus)) break;				
			}
			if(minus < 0 && plus > 1000_000) {
				System.out.println(Math.abs(n-100));
				return;
			}
			plus++;
			minus--;
			res++;
		}
		// 번호를 채널 사이즈만큼 누르므로 그만큼 더해줌(minus, plus를 동시에 도달하는 경우가 있음 -- 번호자리수가 적은 것 선택)
		boolean mP = possible(plus);
		boolean mM = false;
		if(minus >= 0) mM = possible(minus);
		
		if(mM && mP) res += nSize(plus) > nSize(minus) ? nSize(minus) : nSize(plus);
		else if(mP) res += nSize(plus);
		else res += nSize(minus);

		// 번호이동안하고 +,-로만 가는게 더 빠른경우 고려
		res = Math.min(Math.abs(n-100), res);
		
		System.out.println(res);
	}
	
	private static int nSize(int t) {
		int tres = 1;
		int temp = t;
		while(temp/10 != 0) {
			temp /= 10;
			tres++;
		}
		return tres;
	}
	
	private static boolean possible(int cur) {
		while(cur/10 != 0) {
			if(btn[cur%10] == true) return false;
			cur /= 10;
		}
		if(btn[cur%10] == true) return false;
		
		return true;
	}
	
}

