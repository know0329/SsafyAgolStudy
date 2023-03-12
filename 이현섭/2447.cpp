/*
문제 : 별 찍기 - 10
시간 : 40분
ide 활용 : o
질문 보기 : x
피드백 : 제출 했을때 math.h를 안 넣어서 컴파일 오류가 떳다..
처음에는 따로 저장 안하고 출력할려니 너무 불편하고 계행 넣기도 힘들어서 따로 배열에 index로 접근하면서 풀엇다.
재귀를 돌며 x,y의 값을 바꾸면서 i=5일때 now을 바꾸어 나중에는 재귀를 돌며 자연스럽게 ' '을 넣도록했따.
x,y로 그냥 하니까 x의 값을 초기화하기 힘들 nx,ny로 처리했다.

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
#include <math.h>

using namespace std;

int cnt = -1;
vector<vector<char>> arr;
int n;

void dfs(int depth,int now,int y,int x)//3^depth, now==1 * now==0 공백 출력 idx
{
	if (depth == 0)
	{
		if (now == 0)
			arr[y][x] = ' ';
		return;
	}
	int nx = x;
	int ny = y;
	for (int i = 1; i <= 9; i++)
	{
		if (i == 5)
			dfs(depth -1, 0,ny,nx);
		else
			dfs(depth -1, now, ny, nx);

		if (i % 3 == 0)
		{
			ny = ny+pow(3, depth - 1);
			nx = x;
		}
		else
			nx = nx + pow(3,depth - 1);
	}
}

int main(void)
{

	scanf("%d", &n);
	int temp = n;

	for (int i = 0; i <= n; i++)
	{
		vector<char> t;
		for (int j = 0; j <= n; j++)
		{
			t.push_back('*');
		}
		arr.push_back(t);
	}

	while (temp)
	{
		temp /= 3;
		cnt++;
	}

	dfs(cnt,1,1,1);

	for (int i = 1; i <= n; i++)
	{
		for (int j = 1; j <= n; j++)
		{
			printf("%c", arr[i][j]);
		}
		printf("\n");
	}
}
