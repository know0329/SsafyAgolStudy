package study_0323;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9527 {
	static long[] DP = new long[56];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		//누적합 계산
		setDp();
		//A ≤ n ≤ B : B의 누적합 - (A-1)의 누적합 구하기
		long result = calOne(B) - calOne(A-1);
//		long result = 0;
//		for(long i=A; i<=B; i++) {
//			result += dp(i);
//		}
		System.out.println(result);
	}
	
	//DP[n] = DP[n-1] × 2 + 2ⁿ을 이용하여 누적합 저장하는 함수
	static void setDp() {
        DP[0] = 1;	//DP[0]은 1으로 초기화
        //점화식 적용
        //DP[i-1] << 1 : DP[n-1] × 2
        //1L << i : 2ⁿ
        for(int i=1;i<55;i++)
            DP[i] = (DP[i-1] << 1) + (1L << i);
    }
	
	//1~N 정수에 대한 1의 개수 구하는 함수
    static long calOne(long N) {
        long count = N & 1;
        //N보다 작은 2ⁿ의 n의 최대값
        int size = (int) (Math.log(N)/Math.log(2));
        //비트마스킹을 이용한 1의 개수 계산 진행
        //DP[i-1] : 000 ~ 111 개수
        //N - (1L << i) : 지정된 1이 반복 사용될 개수 
        // + 1 : 1000... 
        for(int i=size;i>0;i--) {
            if((N & (1L<<i)) != 0L) {
                count += DP[i-1] +(N - (1L<<i) + 1);
                N -= (1L << i);	//비트 이동시키기
            }
        }
        return count;	//1의 개수 반환
    }
	
	// 런타임 에러, 시간 초과
//	static long dp(long num) {
//		if(num == 0) return 0;
//		if(num == 1) return 1;
//		if(num == 2) return 1;
//		if(num == 3) return 2;
//		if(num == 4) return 1;
//		
//		if(num%2 == 0) return dp(num/2);
//		else return dp(num/2) + 1;
//	}
}
