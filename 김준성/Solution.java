import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int N, W, H, result;
    static int[] select;
    static int[][] arr, origArr;
    static int [][] dir = {{0,1}, {1, 0}, {0, -1}, {-1, 0}};
    static void rec(int count) {
        if (count == N) {
            copyArr();
            for(int i=0; i<N; i++) {
                throwBall(select[i]);
                fallBricks();
            }
            result = Math.min(result, getRemains());
            return;
        }

        for(int i=0; i<W && result > 0; i++) {
            select[count] = i;
            rec(count+1);
        }
    }

    static void fallBricks() {
        for(int j=0; j<W; j++) {
            int ceil = H-1;

            for(int brick = H-1; brick>=0; brick--) {
                if (arr[brick][j] != 0) {
                    arr[ceil][j] = arr[brick][j];
                    if (ceil != brick) arr[brick][j] = 0;
                    ceil--;
                }
            }
        }
    }

    static void throwBall(int col) {
        int brickR = 0;
        int index = 0;

        while(index < H) {
            if (arr[index][col] != 0) {
                brickR = index;
                break;
            }
            index++;
        }

        if (index == H) return;

        breakBricks(brickR, col);
    }

    static void breakBricks(int r, int c) {
        if (arr[r][c] == 1) {
            arr[r][c] = 0;
            return;
        }

        int range = arr[r][c] - 1;
        arr[r][c] = 0;

        for(int i=0; i<4; i++) {
            int nr = r;
            int nc = c;

            for(int j=0; j<range; j++) {
                nr += dir[i][0];
                nc += dir[i][1];

                if (nr < 0 || nc < 0 || nr >= H || nc >= W) break;

                if (arr[nr][nc] != 0) {
                    breakBricks(nr, nc);
                }
            }
        }
    }

    static int getRemains() {
        int result = 0;
        for(int i=0; i<H; i++) {
            for(int j=0; j<W; j++) {
                if (arr[i][j] > 0) {
                    result++;
                }
            }
        }
        return result;
    }

    static void copyArr() {
        arr = new int[H][W];
        for(int i=0; i<H; i++) {
            for(int j=0; j<W; j++) {
                arr[i][j] = origArr[i][j];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            origArr = new int[H][W];
            select = new int[N];
            result = Integer.MAX_VALUE;

            for(int i=0; i<H; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<W; j++) {
                    origArr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            rec(0);
            System.out.println("#"+t+" "+result);
        }
    }



}