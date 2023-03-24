/*
문제 : 효율적인 해킹
시간 : 2시간 30분
ide 활용 : x
질문 보기 : o
피드백 : 처음에는 그리디 하게 생각해서 들어오는게 없으면 제일 위에 있는 트리노드라고 생각해서 풀었다.
하지만 서클이 되면 예외의 상황이 나와서 계속 고민하다가 처음에는 10만개라서 최대가 10만*10만/2라고 생각했지만
다시 생각하니 노드는 최대 만개이기 때문에 방문체크만하면 만*만/2이므로 대충 어떻게든 될거 같다는 생각이 들었따.
그래서 그냥 bfs로 풀었더니 맞앗다..... 조금 어이가 없엇다.

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

vector<vector<int>> arr(10001);
int vit[10001];
vector<int> ans(10001);

int main(void)
{
	int T;
	int n,m;
	int a, b;
	scanf("%d %d", &n, &m);

	for (int i = 0; i < m; i++)
	{
		scanf("%d %d", &a, &b);
		arr[b].push_back(a);
	}
	
	for (int i = 1; i <= n; i++)
	{
		queue<int> q;
		vector<int> temp;
		q.push(i);
		vit[i] = 1;
		int cnt = 0;
		while (!q.empty())
		{
			int now = q.front();
			q.pop();
			vit[now] = 1;
			temp.push_back(now);
			cnt++;
			for (int j = 0; j < arr[now].size(); j++)
			{
				int next = arr[now][j];
				if (vit[next] == 1)
					continue;
				q.push(next);
				vit[next] = 1;
			}
			
		}
		for (int j = 0; j < temp.size(); j++)
		{
			vit[temp[j]] = 0;
		}
		ans[i] = cnt;
	}

	int maxNum = *max_element(ans.begin(), ans.end());
	for (int i = 1; i <= n; i++)
	{
		if (maxNum == ans[i])
			printf("%d ", i);
	}
	
}
