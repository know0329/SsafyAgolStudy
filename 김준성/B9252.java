import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 참조 코드 : https://soojong.tistory.com/entry/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98%EC%9E%90%EB%B0%94-%EB%B0%B1%EC%A4%80-9252%EB%B2%88-LCS-2


 /*
 *  0 A C A Y K P
 *0 0 0 0 0 0 0 0
 *C 0 0 1 1 1 1 1
 *A 0 1 1 2 2 2 2
 *P 0 1 1 2 2 2 3
 *C 0 1 2 2 2 2 3
 *A 0 1 2 3 3 3 3
 *K 0 1 2 3 3 4 4
 * */
public class B9252 {


    static int[][] dp = new int[1001][1001]; // 최대 1000글자
    static String[] n1;
    static String[] n2;

    public static void main(String[] args) throws IOException{


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        n1 = br.readLine().split("");
        n2 = br.readLine().split("");
        String ans = solve();

        System.out.println(ans.length());
        if(ans.length()!=0 ) System.out.println(ans);


    }


    //최장 부분 수열 구하기 현재 문자열에서 비교하는 문자가 서로 다르면 전의 값들(왼쪽 / 윗쪽)중 큰 수를 할당
    // 비교할때 문자가 서로 같다면 왼쪽 대각선의 값 + 1 할당
    public static String solve() {

        // 테이블 그리기
        for(int i=0; i<n1.length; i++) {
            for(int j=0; j<n2.length; j++) {
                if(n1[i].equals(n2[j])) {
                    dp[i+1][j+1] = dp[i][j]+1;
                }
                else {
                    dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }

        int x = n1.length;
        int y = n2.length;
        String a = "";
        // 부분수열 구하기 시작 => 최장 수열의 길이를 구하는 것의 반대로 가면 됨
        while(x>0 && y>0) {

            if(dp[x-1][y] == dp[x][y]) { // 왼쪽값과 같다 => LCS를 구할 떄 왼쪽값이 오른쪽 값보다 컸다
                x-=1;
            } else if(dp[x][y-1] == dp[x][y]) { // 윗쪽값과 같다. => LCS를 구할 떄 위쪽값이 왼쪽 값보다 컸다
                y-=1;
            } else { // 왼쪽값과 윗쪽값과 같은 경우가 없다. => 해당 문자열이 같은 것이었다, 같은 경우 대각선에서 +1이었기에 대각선으로 이동
                a +=n1[x-1];
                x-=1;
                y-=1;

            }
        }

        String ans = "";
        for(int i=a.length()-1; i>=0; i--) {
            ans += a.charAt(i);
        }


        return ans;

    }




}