/*
문제 :
시간 :
ide 활용 : x
질문 보기 : x
피드백 :

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
#include <math.h>

using namespace std;

vector<int> ans;
vector<int> arr;
int n, m;

void dfs(int cnt)
{
	if (cnt == m)
	{
		for (int i = 0; i < m; i++)
		{
			printf("%d ", ans[i]);
		}
		printf("\n");
		return;
	}

	for (int i = 0; i < n; i++)
	{
		ans.push_back(arr[i]);
		dfs(cnt + 1);
		ans.pop_back();
	}
}

int main(void)
{

	int now;
	scanf("%d %d", &n, &m);
	for (int i = 0; i < n; i++) {
		scanf("%d", &now);
		arr.push_back(now);
	}
	sort(arr.begin(), arr.end());
	dfs(0);
}
