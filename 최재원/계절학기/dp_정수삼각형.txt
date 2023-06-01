class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        
        // dp[1][0] ~ dp[triangle.length][triangle.length] 구하기
        for(int i=1; i<triangle.length; i++){
            // 왼쪽
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            
            // 오른쪽 
            dp[i][i] = dp[i-1][i-1] + triangle[i][i];
            
            // 가운데
            for(int j=1; j<=i; j++)
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
        }
        
        // dp의 마지막 줄에서 최대값 구하기
        for(int i=0; i<triangle.length; i++)
            answer = Math.max(answer, dp[triangle.length-1][i]);
        return answer;
    }
}