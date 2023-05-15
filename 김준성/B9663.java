import java.io.*;
import java.util.*;
// backjoon - 9663
public class B9663 {
    static int num;
    static int result;
    static int[] col;
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        num = scn.nextInt();
        col = new int[num+1];
        nQueen(1);
        System.out.print(result);
    }

    static boolean attackable(int r1, int c1, int r2, int c2) {
        if (c1 == c2) return true; // 열(세로)이 같은 경우
        if (r1 - c1 == r2 - c2) return true;  // 왼쪽 위 대각선에 이미 놓여져 있다.
        if (r1 + c1 == r2 + c2) return true; // 오른쪽 위 대각선에 이미 놓여져 있다.
        return false;
    }

    static void nQueen(int row) {
        if(row == num + 1) {
            result++;
        }
        else {

            for(int c = 1; c <= num; c++) {
                boolean possible = true;
                for(int i = 1; i <= row-1; i++) {
                    if(attackable(row, c, i, col[i])) {
                        possible = false;
                        break;
                    }
                }
                //가지치기를 통해서 시간복잡도를 줄임
                if (possible) {
                    col[row] = c;
                    nQueen(row + 1);
                    col[row] = 0;
                }
            }
        }
    }

}