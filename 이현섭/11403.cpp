/*
문제 :경로 찾기
시간 :1시간
ide 활용 : x
질문 보기 : x
피드백 : 그냥 bfs로 하나하나씩 찾았다.
100*100*100 정도 나온다. 먼가 더 쉽게 풀수있을거 같은데 스터디원들에게 부탁한다.

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

int arr[101][101];
vector<vector<int>> graph(101);
int ans[101][101];
int n;

void bfs(int i,int j)
{
	queue<int> q;
	int vit[101] = { 0 };
	q.push(i);
	while (!q.empty())
	{
		int now = q.front();
		q.pop();
		for (int k = 0; k < graph[now].size(); k++)
		{
			if (vit[graph[now][k]] == 1)
				continue;
			q.push(graph[now][k]);
			vit[graph[now][k]]=1;
			if (graph[now][k] == j)
			{
				ans[i][j] = 1;
				return;
			}
		}
	}
}

int main(void)
{
	scanf("%d", &n);

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			scanf("%d", &arr[i][j]);
			if(arr[i][j]==1)
				graph[i].push_back(j);
		}
	}

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			bfs(i, j);
		}
	}

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			printf("%d ", ans[i][j]);
		}
		printf("\n");
	}
}

