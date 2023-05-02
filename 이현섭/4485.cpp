/*
문제 :녹색 옷 입은 애가 젤다지?
시간 : 20분
ide 활용 : x
질문 보기 : x
피드백 : 그냥 bfs돌면서 값을 업데이트하면서 풀엇다.
개행을 안넣어서 틀렷다.
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

int dx[4] = { 1,0,-1,0 };
int dy[4] = { 0,1,0,-1 };

int main(void)
{
	int T;
	int n;
	int now;
	int k = 1;

	while (1)
	{
		scanf("%d", &n);

		int arr[126][126] = { 0 };

		int cnt[126][126];

		if (n == 0)
			break;
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				scanf("%d", &arr[i][j]);
				cnt[i][j] = 199999999;
			}
		}

		queue<pair<int, int>> q;

		q.push({ 0, 0 });
		cnt[0][0] = arr[0][0];
		while (!q.empty())
		{
			int x = q.front().first;
			int y = q.front().second;
			q.pop();

			for (int i = 0; i < 4; i++)
			{
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= n || nx < 0 || ny >= n || ny < 0)
					continue;
				if (cnt[ny][nx] <= cnt[y][x] + arr[ny][nx])
					continue;
				cnt[ny][nx] = cnt[y][x] + arr[ny][nx];

				q.push({ nx, ny });
			}
		}
		printf("Problem %d: %d\n",k,cnt[n-1][n-1]);

		k++;
	}
	
}
