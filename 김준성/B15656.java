import java.util.Arrays;
import java.util.Scanner;


public class B15656 { // 중복 순열 문제

    static int N;
    static int M;

    static int [] arr;

    static int [] choice;
    static StringBuilder sb;
    static void rec(int count){
        if(count == M ){
            for (int i = 0; i < M; i++) {
                sb.append(choice[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 0; i < N; i++){

            choice[count] = arr[i];
            rec(count+1);

        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        N = sc.nextInt();
        arr = new int[N];
        choice = new int[N];
        M = sc.nextInt();

        for(int i = 0 ; i < N ;i++){
            int num = sc.nextInt();
            arr[i] = num;

        }
        Arrays.sort(arr);
        rec(0);
        System.out.println(sb.toString());

    }
}