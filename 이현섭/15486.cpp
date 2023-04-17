/*
문제 : 퇴사 2 
시간 : 2시간
ide 활용 : x
질문 보기 : o
피드백 : 첫 점화식은 잘 구햇는데 2번째 점화식을 생각을 못해서
질문을 보앗다.
그래서 현재 일은 하거나 
현재 일을 안하면 바로 다음꺼를 추가를 해야햇다.
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

vector<int> t;
vector<int> p;
vector<int> dp;

int main(void)
{
	int n;
	int a, b;
	scanf("%d", &n);

	for (int i = 0; i < n; i++)
	{
		scanf("%d %d", &a, &b);
		t.push_back(a);
		p.push_back(b);
		dp.push_back(0);
	}
	for (int i = 0; i < 60; i++)
	{
		p.push_back(0);
		dp.push_back(0);
	}
	for (int i = 0; i < n; i++)
	{
		dp[i + t[i]] = max(dp[i + t[i]], dp[i] + p[i]);
		dp[i + 1] = max(dp[i + 1], dp[i]);
	}
	printf("%d", *max_element(dp.begin(),dp.begin()+n+1));

}
