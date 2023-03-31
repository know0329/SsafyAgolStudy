/*
문제 : 로봇 청소기
시간 : 45분
ide 활용 : o
질문 보기 : o
피드백 : 단순 구현으로 풀엇다.
일단 현재좌표에서 무조건 반시계로 회전하게 햇다. 그리고 방향도 계쏙 업데이트 해줬따.
문제는 startx starty를 반대로 한게 첫번쨰 실수고 4방향 텅빈 곳이 없을 때
뒤로 가는 것을 arr[nx][ny]로 해서 이상하게 나왓던 것이다.. 디버깅할 때 자세히 봣으면
2번째 이유는 잘 봣을거 같은데 너무 아쉽다.
다른사람 문제 보니 dfs로 푼사람이 많았따.

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

int vit[51][51];
int arr[51][51];

int dx[4] = {0,1,0,-1};// 북동남서
int dy[4] = { -1,0,1,0 };

int main(void)
{
	int m, n;
	int startX, startY, dir;
	int ans = 0;

	scanf("%d %d", &n, &m);

	scanf("%d %d %d", &startY, &startX, &dir);
	
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			scanf("%d", &arr[i][j]);
		}
	}
	int nowDir = dir;
	int x = startX;
	int y = startY;
	while (1)
	{
		if (vit[y][x] == 0)
		{
			ans++;
			vit[y][x] = 1;
		}
		int i;
		for (i = 0; i < 4; i++)
		{
			int nDir = (dir +(3-i)) % 4;
			int nx = x + dx[nDir];
			int ny = y + dy[nDir];
			if (arr[ny][nx] == 1)
				continue;
			if (vit[ny][nx] == 1)
				continue;
			x = nx;
			y = ny;
			dir = nDir;
			break;
		}
		if (i == 4)
		{
			int nDir = (dir + 2) % 4;
			int nx = x + dx[nDir];
			int ny = y + dy[nDir];
			if (arr[ny][nx] == 1)
				break;
			x = nx;
			y = ny;
		}
	}

	printf("%d", ans);

}
