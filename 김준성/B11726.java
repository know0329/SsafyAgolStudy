import java.util.*;
import java.io.*;
class B11726 // 그려보면 피보나치 형태의 점화식이 구해짐
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int [] pivo = new int[N+1];
        pivo[0] = 1;
        pivo[1] = 2;
        for(int i = 2; i <N; i++) {
            pivo[i] = (pivo[i-1]  + pivo[i-2]) % 10007;
        }
        System.out.println(pivo[N-1] % 10007);

    }
}