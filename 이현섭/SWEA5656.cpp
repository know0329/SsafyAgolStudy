/*
문제 : 벽돌 깨기
시간 : 1시간반
ide 활용 : o
질문 보기 : x
피드백 : 단순 구현 문제이다.
먼저 dfs로 n==3인 경우 000 001 002 ... w-1w-1w-1 까지 모든 경우를 돌게 햇다.
그 다음 bfs로 없애야할 곳을 없애고
모든 배열 다돌면서 매줄마다 새로운 배열에 값을 넣어 다시 넣게 했따.<--여기서 시간이 많이 걸릴듯...
ans를 두번 선언해서 계속 0이 나오길래 왜그렇지 하다 시간이 오래걸렷다.
일단 거의 완탐으로 풀어서 2초정도 걸리는데 시간을 줄이게 해봐야겟다.
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

struct Cood
{
	int x, y;
	Cood(int X, int Y) {
		x = X;
		y = Y;
	}
};

int dx[4] = { 1,0,-1,0 };//동남서북
int dy[4] = { 0,1,0,-1 };

int n, w, h;
int ans = 1999999999;

void dfs(int index, vector<vector<int>> now)//몇번 떨궛나, 몇번째 떨굴차례냐,현재 arr
{
	if (index == n)
	{
		int cnt=0;
		for (int i = 0; i < h; i++)
		{
			for (int j = 0; j < w; j++)
			{
				if (now[i][j] != 0)
					cnt++;
			}
		}
		ans = min(ans, cnt);
		return;
	}
	for (int i = 0; i < w; i++)
	{
		vector<vector<int>> temp = now;
		int j;
		for (j = 0; j < h; j++)
		{
			if (temp[j][i] !=0 )
			{
				break;
			}
		}
		if (j != h)//bfs돌면서 0으로 만들기
		{
			queue<Cood> q;
			q.push(Cood(i, j));
			while (!q.empty())
			{
				int x = q.front().x;
				int y = q.front().y;
				int power = temp[y][x];
				temp[y][x] = 0;
				q.pop();
				for (int j = 0; j < 4; j++)
				{
					int nx = x;
					int ny = y;
					for (int k = 0; k < power - 1; k++)
					{
						nx += dx[j];
						ny += dy[j];
						if (nx >= w || nx < 0 || ny >= h || ny < 0)
							break;
						if (temp[ny][nx] == 0)
							continue;
						q.push(Cood(nx, ny));
					}
				}
			}

		}

		for (j = 0; j < w; j++)//시간 줄일 수 있을듯?
		{
			vector<int> tt;
			for (int k = h-1; k >= 0; k--)
			{
				if (temp[k][j] != 0)
				{
					tt.push_back(temp[k][j]);
					temp[k][j] = 0;
				}
			}
			int l = h-1;
			for (int k = 0; k < tt.size(); k++)
			{
				temp[l][j] = tt[k];
				l--;
			}
		}
		dfs(index + 1,temp);
	}
}
int main(void)
{
	int T;

	int now;
	vector<vector<int>> arr(16);
	freopen("input.txt", "r", stdin);
	scanf("%d", &T);
	for (int test_case = 1; test_case <= T; ++test_case)
	{
		scanf("%d %d %d", &n,&w,&h);//n 공 갯수 

		for (int i = 0; i < h; i++)
		{
			vector<int> input;
			for (int j = 0; j < w; j++)
			{
				scanf("%d", &now);
				input.push_back(now);
			}
			arr[i] = input;
		}

		dfs(0,arr);

		printf("#%d %d\n", test_case, ans);
		ans = 199999999;
	}
}
