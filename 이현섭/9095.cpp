/*
문제 : 1, 2, 3 더하기
시간 : 풀어본 문제
ide 활용 : x
질문 보기 : x
피드백 : dp를 이용한다.
1,2,3의 경우의 수를 각각 구하고 4부터는 1,2,3인 경우에 +3,+2,+1 하면 되는 것을 이용했다.
*/
#include <stdio.h>
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int dp[11];

int main(void)
{
    int n,m;
    
    scanf("%d",&n);
    
    dp[1]=1;
    dp[2]=2;
    dp[3]=4;
    for(int i=4;i<11;i++)
    {
        dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
    }
    
    
    for(int j=0;j<n;j++)
    {
        scanf("%d",&m);
        
        printf("%d\n",dp[m]);
    }
    
    
    //printf("%d",dp[n]);

}
