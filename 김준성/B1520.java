import java.io.*;
import java.util.*;
public class B1520 {

    static int N, M;
    static int [][] arr, dp;
    static int [][]  dir = {{0, 1}, {-1, 0}, {1, 0}, {0, -1}};
    public static int DFS(int x, int y) {
        if (x == M && y == N) {
            return 1;
        }
        //방문했다면 리턴 => 중복으로 dfs를 하는 것 방지
        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        dp[x][y] = 0; // 방문하지 않았다면 방문 처리
        for (int i = 0; i < 4; i++) {
            int dx = x + dir[i][0];
            int dy = y + dir[i][1];

            if (dx < 1 || dy < 1 || dx > M || dy > N) {
                continue;
            }

            // 이동한 부분이 낮은 부분이라면?
            if (arr[x][y] > arr[dx][dy]) {
                dp[x][y] += DFS(dx, dy);
            }
        }

        return dp[x][y];
    }


    public static void main(String [] args){

        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        arr = new int[M+1][N+1];
        dp = new int[M+1][N+1];
        for (int i = 1; i <= M; i ++){
            for(int j = 1; j <= N; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        dp = new int[M + 1][N + 1]; // (x, y)에서 도착점으로 가는 경로의 개수
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                // 0으로 하니까 시간초과가 남 => 찾아보니 0의 경우의 수도 있다고 함
                dp[i][j] = -1;
            }
        }
       System.out.println(DFS(1,1 ));
    }
}

