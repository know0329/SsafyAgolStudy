/*
문제 : N과 M (12)
시간 : 15분
ide 활용 : x
질문 보기 : x
피드백 : 그냥 조건에 맞게 출력하면된다.
지금까지 라이브러리를 썻는데 이번꺼는 못쓸거같아 스터디원들의 n과 m문제풀이를
기억하면서 풀었따.
일단 바로 전 숫자보다 작은 수는 다음수가 될 수없기 때문에 시작하는 부분을 줘서 풀었따.
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

vector<int> arr;
int ans[8];

int n, m;

void dfs(int idx,int s)//idx 현재 몇개?,now숫자
{
	if (idx == m)
	{
		for (int i = 0; i < m; i++)
		{
			printf("%d ", ans[i]);
		}
		printf("\n");
		return;
	}
	for (int i = s; i < arr.size(); i++)
	{
		ans[idx] = arr[i];
		dfs(idx + 1, i);
	}
}

int main(void)
{
	scanf("%d %d", &n, &m);
	int temp;
	for (int i = 0; i < n; i++)
	{
		scanf("%d", &temp);
		arr.push_back(temp);
	}
	
	sort(arr.begin(), arr.end());
	arr.erase(unique(arr.begin(), arr.end()), arr.end());

	dfs(0, 0);
}
