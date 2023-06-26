// dp 같아보임
// 카탈란 수
class Solution {
    public int solution(int n) {
        int[] dp = new int[15];

        dp[0] = 1;
        
        for(int i=1;i<15;i++) {
            for(int j=0;j<i;j++){
                dp[i] += dp[j]*dp[i-j-1];                
            }
        }
        
        return dp[n];
    }
}