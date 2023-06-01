import java.util.*;
import java.io.*;

class Solution {
    static int[][] dp = new int[500][500]; // 누적합 저장
    public int solution(int[][] triangle) {
        int res = 0;
        int loop = triangle.length; // 입력 높이

        dp[0][0] = triangle[0][0]; // 루트 노드는 부모가 없음
        for(int i = 1; i<loop; i++) { // 루트노드 이후 부터 최대 값 탐색
            // 현재 높이(i+1) == 원소 갯수
            for(int j=0;j<i+1;j++) {
                int me = triangle[i][j];
                int leftMax = dp[i-1][j];
                if(j-1 >= 0) leftMax = dp[i-1][j-1];
                int rightMax = dp[i-1][j];
                System.out.println(rightMax);
                
                dp[i][j] = Math.max(leftMax + me, rightMax + me);
            }
        }
        
        for(int i=0;i<loop;i++) res = Math.max(dp[loop-1][i], res);
        return res;
    }
}