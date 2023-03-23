import java.util.Scanner;
public class B2293{

    static int [] dp;

    static int [] coin;
    public static void main(String[] args)  {
        Scanner scn = new Scanner(System.in);


        int N = scn.nextInt();
        int K = scn.nextInt();
        dp = new int[K+1];
        coin = new int[N];
        for (int i = 0; i < N; i++) {
            coin[i] = scn.nextInt();
        }
        dp[0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= K; j++) {
                if (j >= coin[i])
                    dp[j] += dp[j - coin[i]];
            }
        }
        System.out.println(dp[K]);
    }

}