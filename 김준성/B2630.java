import java.util.*;
import java.io.*;

public class B2630
{
    static int [][] arr;
    static int white;
    static int blue;
    static void rec(int x, int y, int size) {
        boolean check = true;
        int checkingValue = arr[x][y];
        for(int i = x; i < x+ size; i++) {
            for(int j = y; j < y+ size; j++) {
                if(arr[i][j] != checkingValue) {
                    check = false;
                }
            }
            if(!check)
                break;
        }
        if(check) {
            if(checkingValue == 1){
                blue++;
            }
            else{
                white++;
            }
            return;
        }
        else {
            rec(x, y, size/2);
            rec(x, y+size/2, size/2);
            rec(x + size/2, y, size/2);
            rec(x+size/2, y + size/2, size/2);
        }
    }
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        for(int i = 0 ; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }
        rec(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }
}