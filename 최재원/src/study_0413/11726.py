N = int(input())


dp = [0,1,2,3,5,8,13]

for i in range(7,1001):
    dp.append(dp[i-2] + dp[i-1])
print(dp[N] % 10007)