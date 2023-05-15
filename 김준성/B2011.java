import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String password = br.readLine();
        int n = password.length();
        int[] dp = new int[n + 1];
        char[] ch = new char[n + 1];
        for(int i = 1; i <= n; i++) {
            ch[i] = password.charAt(i-1);
        }
        dp[0] = 1;
        // 첫쨰 자리 숫자 부터 확인
        for(int i = 1; i <= n; i++) {
            // 한자리인 경우
            int num = ch[i] - '0';
            if(1 <= num && num <= 9) {
                dp[i] = dp[i-1];
                dp[i] %= 1000000;
            }
            // 두 수 합쳐서 알파벳 하나인 경우. 10~26
            num = (ch[i-1] - '0') * 10 + (ch[i] - '0');
            if(10 <= num && num <= 26) {
                dp[i] += dp[i-2];
                dp[i] %= 1000000;
            }
        }
        System.out.println(dp[n]);
    }
}