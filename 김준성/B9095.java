import java.io.*;
import java.util.*;

/*
 
1 => 1개
2 => 1+1, 2 =>2개
3 => 1+1+1, 2+1, 1+2, 3 => 4개

4 => 7개

5 = > 7 +   a

4의 경우에서 => 7개
1+1+1+1+(1)
1+1+2+(1)
1+2+1+(1)
2+1+1+(1)
2+2+(1)
1+3+(1)
3+1+(1)

3의 경우에서 => 4
1+1+1+(2)
2+1 +(2)
1+2+(2)
3+ (2)
2의 경우에서 = >2
1+1+(3)
2 +(3)

1 2 4 7 13 24 44 81 149 274 
  */

public class B9095 {

    static int T;
    static int [] arr;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        arr = new int[11];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;

        for(int i = 4; i < 11; i++) {
            arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
        }

        for (int i = 0; i < T; i++) {
            int num = sc.nextInt();
            System.out.println(arr[num]);
        }

    }
}