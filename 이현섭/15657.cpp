/*
문제 : N과 M (8)
시간 : 1분
ide 활용 : x
질문 보기 : x
피드백 : n과 m 12랑 똑같다.
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
#include <math.h>

using namespace std;

vector<int> arr;
int ans[8];

int n, m;

void dfs(int idx, int s)//idx 현재 몇개?,now숫자
{
	if (idx == m)
	{
		for (int i = 0; i < m; i++)
		{
			printf("%d ", ans[i]);
		}
		printf("\n");
		return;
	}
	for (int i = s; i < arr.size(); i++)
	{
		ans[idx] = arr[i];
		dfs(idx + 1, i);
	}
}

int main(void)
{
	scanf("%d %d", &n, &m);
	int temp;
	for (int i = 0; i < n; i++)
	{
		scanf("%d", &temp);
		arr.push_back(temp);
	}

	sort(arr.begin(), arr.end());
	arr.erase(unique(arr.begin(), arr.end()), arr.end());

	dfs(0, 0);
}
