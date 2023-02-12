import java.util.*;
import java.io.*;
// backjoon

public class B1074 {


    static int result;

    static void rec(int size, int r, int c){
        System.out.println("result : " + result);
        if(size <= 1){
            return;
        }
        else {
            // 1사분면
            if (r < size/2 && c < size/2) {
                rec(size/2, r, c);
            }
            // 2사분면
            else if (r < size/2 && c >= size/2){
                result += size * size/4;
                rec(size/2, r, c - size/2);

            }
            // 3사분면
            else if(r >= size/2 && c < size/2) {
                result += (size * size / 4) * 2;
                rec(size/2, r - size/2, c);
            }
            // 4사분면
            else {
                result += (size * size / 4) * 3;
                rec(size/2, r - size/2, c - size/2);
            }
        }

    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //  1 ≤ N ≤ 15, 0 ≤ r, c < 2N 이니까 int 범위를 넘어가지 않음 => int 사용
        // 배열을 4등분하여 각각을 1,2,3,4 분면이라고 하였을 때 각 분면의 시작점은 2^(행 길이 ^ 2 /4)에 0,1,2,3을 곱한 만큼의 횟수 때 방문
        // 더 이상 쪼갤 수 없을 때 까지 쪼개면서 횟수를 더해주면 답이 나온다.
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int size = (int)Math.pow(2, N);
        rec(size, r, c);

        System.out.println(result);


    }
}
