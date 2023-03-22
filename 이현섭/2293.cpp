/*
문제 : 동전 1
시간 : 2시간
ide 활용 : x
질문 보기 : o
피드백 : 여러가지 방향으로 생각해봣는데 도저히 생각이 안나서 다른 분들거 참고했다.
처음에는 동전 배수만큼 먼저 채우고 하나씩 풀면 되지 않을까 생각해서 풀엇는데 어떻게 하든 겹치게 나온다.(문제는 조합만 찾는중)
참고해보니 그냥 동전을 한개씩 넣는 느낌으로 풀었다. 그리고 자기 자신을 최초로 넣을 때는 암것도 안넣는것도 방법이라고 생각해서 0도 1로줫다.

*/
#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <string>
#include <vector>
#include <queue>
#include <map>
#include <set>
#include <list>
#include <unordered_map>
#include <algorithm>
#include <stack>

using namespace std;
int ans[10001];

int main(void)
{
	int n, k;

	vector<int> arr(10001);
	vector<int> coin;
	
	scanf("%d %d", &n, &k);
	coin.push_back(0);
	for (int i = 0; i < n; i++)
	{
		int temp;
		scanf("%d", &temp);
		coin.push_back(temp);	
	}
	sort(coin.begin(), coin.end());
	if (coin[1] > k)
	{
		printf("0");
		return 0;
	}
	arr[0] = 1;
	for (int i = 1; i < coin.size(); i++)
	{
		for (int j = coin[i]; j <= k; j++)
		{
			arr[j] = arr[j] + arr[j - coin[i]];
		}
	}

	printf("%d", arr[k]);
}
