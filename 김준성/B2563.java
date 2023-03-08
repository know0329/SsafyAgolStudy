import java.util.*;
import java.io.*;


public class B2563
{
    static int [][] white;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        white = new int[100][100];

        int area = 0;
        for(int i =0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y =Integer.parseInt(st.nextToken());

            for(int j = x; j < x + 10; j++){ // 가로 10
                for(int k = y; k < y+10; k++){ // 세로 10
                    white[j][k] = 1; // 겹쳐도 1로 표시됨.
                }
            }
        }

        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j++){
                if(white[i][j] == 1) area ++; // 1하나당 넓이가 1이니까 ++;
            }
        }
        System.out.println(area);


    }
}