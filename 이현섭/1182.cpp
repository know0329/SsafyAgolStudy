/*
문제 : 부분수열의 합
시간 : 10분
ide 활용 : x
질문 보기 : x
피드백 : 그냥 부분수열 구하는 문제엿다.

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

int arr[21];
int vit[21];
int ans;
int n, s;

void dfs(int now, int index)//now 현재숫자,index 좌표
{
	if (index == n)
	{
		return;
	}
	vit[index] = 1;
	now += arr[index];
	if (now == s)
		ans++;
	dfs(now, index + 1);
	vit[index] = 0;
	now -= arr[index];
	dfs(now, index + 1);
}

int main(void)
{
	scanf("%d %d", &n, &s);
	for (int i = 0; i < n; i++)
	{
		scanf("%d", &arr[i]);
	}

	dfs(0, 0);
	printf("%d", ans);
}
