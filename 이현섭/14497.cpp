/*
문제 : 주난의 난
시간 : 30분
ide 활용 : x
질문 보기 : o
피드백 : 문제를 안풀고 바로 팀원들의 설명을 들어서 기억나는 방법으로 풀엇다.
단순 bfs해주면 되는데 1일때 방문체크를 해야하는데 안해서 계속 이상하게 나왓다.

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

int dx[4] = { 0,1,0,-1 };
int dy[4] = { -1,0,1,0 };//북동남서

char arr[301][301];
int vit[301][301];
struct Cood {
	int x, y;
	Cood(int _x, int _y)
	{
		x = _x;
		y = _y;
	}
};

int main(void) {

	int n, m;
	int sx, sy, ax, ay;
	int cnt = 0;
	scanf("%d %d", &n, &m);

	scanf("%d %d %d %d", &sy, &sx, &ay, &ax);

	for (int i = 1; i <= n; i++)
	{
		for (int j = 1; j <= m; j++)
		{
			scanf(" %1c", &arr[i][j]);
		}
	}
	
	while (1)
	{
		cnt++;
		queue<Cood> q;
		q.push(Cood(sx, sy));
		vit[sy][sx] = 1;
		while (!q.empty())
		{
			int x = q.front().x;
			int y = q.front().y;
			q.pop();
			if (x == ax && y == ay)
			{
				printf("%d", cnt);
				return 0;
			}
			for (int i = 0; i < 4; i++)
			{
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx > m || nx <= 0 || ny > n || ny <= 0 || vit[ny][nx] == 1)
					continue;

				if (arr[ny][nx] == '1')
				{
					arr[ny][nx] = '0';
					vit[ny][nx] = 1;
					continue;
				}
				vit[ny][nx] = 1;
				q.push(Cood(nx, ny));
			}
		}
		for (int i = 1; i <= n; i++)
		{
			for (int j = 1; j <= m; j++)
			{
				vit[i][j] = 0;
			}
		}
	}
	
}
