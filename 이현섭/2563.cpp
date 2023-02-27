/*
문제 : 색종이
시간 : 10분
ide 활용 : x
질문 보기 : x
피드백 : 텅빈 배열에 그냥 입력받은 점에서 x,y 각각 10만큼 for문을 돌며 1을 추가했다.
그다음 모든 배열을 돌며 1인숫자만큼 더했다.
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

using namespace std;

int arr[101][101];

int main(void)
{
	int n;
	scanf("%d", &n);
	int ans = 0;
	int x, y;

	for (int i = 0; i < n; i++)
	{
		scanf("%d %d", &x, &y);
		for (int j = y; j < y + 10; j++)
		{
			for (int k = x; k < x + 10; k++)
			{
				arr[j][k] = 1;
			}
		}
	}

	for (int i = 1; i <= 100; i++)
	{
		for (int j = 1; j <= 100; j++) 
		{
			if (arr[i][j] == 1)
				ans++;
		}
	}
	printf("%d", ans);
}
