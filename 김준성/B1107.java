import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B1107 {

    static boolean[] cantUsebuttons;

    static int cur;
    static int curNum;

    static void rec(int max, int count, int sum, int N) {
//		System.out.println(sum);
        if(count != 0) {
            if (Math.abs(sum - N) <= cur) {
                if(Math.abs(sum - N) < cur) {
                    cur = Math.abs(sum - N);

                    curNum = sum;
                }
                else {
                    if(Integer.toString(curNum).length() > Integer.toString(sum).length()) { // 같은 차이가 있다면 숫자가 작은 것을 반영
                        curNum = sum;
                    }
                }

            }
        }
        if (count == max) {
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!cantUsebuttons[i]) {

                rec(max, count + 1, sum + (int) (i * Math.pow(10, count)), N);

            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        cur = Integer.MAX_VALUE;
        curNum = 10000000;

        cantUsebuttons = new boolean[10];
        for (int i = 0; i < M; i++) {
            int brokenButton = sc.nextInt();

            cantUsebuttons[brokenButton] = true;
        }


//		System.out.println("````````");
        if(M != 10) {
            rec(Integer.toString(N).length() + 1, 0, 0, N);
            int result = Math.min(Math.abs(N - 100), cur + Integer.toString(curNum).length());
            System.out.println(result);
        }
        else {
            System.out.println(Math.abs(N - 100));
        }
//		System.out.println(cur);
//		System.out.println(curNum);


    }

}