/*
문제 : 중량제한
시간 : 4시간
ide 활용 : x
질문 보기 : o
피드백 : 처음에는 경우의 수를 최대한 줄이면서 햇는데
26%에 벽에 막혀 질문을 보고 이분탐색으로 푸는 것을 알앗다.
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

struct Node
{
	int st;
	int ma;
	Node(int _st, int _ma)
	{
		st = _st;
		ma = _ma;
	}
};

int n, m;
int a, b;

bool bfs(int mid, vector<map<int, int>> arr, vector<int> vit)
{
	queue<int> q;
	q.push(a);
	vit[a] = 1;
	while (!q.empty())
	{
		int start = q.front();
		q.pop();
		if (b == start)
			return true;
		for (auto iter = arr[start].begin(); iter != arr[start].end(); iter++)
		{
			int fi = (*iter).first;
			int nextPo = (*iter).second;

			if (mid > nextPo)
				continue;
			if (vit[fi] == 1)
				continue;

			vit[fi] = 1;
			q.push(fi);
		}
	}
	return false;
}

int main(void)
{

	int c;
	scanf("%d %d", &n, &m);
	int mi = 2000000000;
	int ma = -1;


	vector<map<int, int>> arr(n + 1);
	vector<int> vit(n + 1, 0);
	for (int i = 0; i < m; i++)
	{
		scanf("%d %d %d", &a, &b, &c);
		if (arr[a].count(b) == 1)
		{
			if (arr[a][b] < c)
			{
				arr[a][b] = c;
				arr[b][a] = c;
			}
		}
		else
		{
			arr[a].insert(make_pair(b, c));
			arr[b].insert(make_pair(a, c));
			ma = max(c, ma);
			mi = min(c, mi);
		}
	}
	scanf("%d %d", &a, &b);
	int left = mi;
	int right = ma;
	int mid = 0;
	int ans = 0;
	while(left<=right)
	{
		mid = (left + right) / 2;
		for (int i = 1; i <= n; i++)
		{
			vit[i] = 0;
		}
		if (bfs(mid, arr, vit))//길 찾음
		{
			left = mid + 1;
			ans = mid;
		}
		else// 길 못찾음
		{
			right = mid - 1;
		}
	}
	
	printf("%d", ans);
}
