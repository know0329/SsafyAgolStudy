/*
문제 :트리
시간 : 25분
ide 활용 : x
질문 보기 : o
피드백 : 트리를 벡터로 만든다.
삭제해야할 노드의 자식을 없앤다.
노드를 없앤다.
cnt를 찾는다.
질문 본 내용 -> 삭제할 노드를 만낫을때 그냥 리턴을 했는데 
그러니 없애도 자식노드가 되는 경우를 못찾았따.
4
-1 0 1 2
2
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

vector<vector<int>> arr;
int cut;
int cnt;

void dfs(int node)
{
	if (arr[node].size() == 0)
	{
		cnt++;
		return;
	}

	for (int i = 0; i < arr[node].size(); i++)
	{
		dfs(arr[node][i]);
	}
}

int main(void)
{
	int n;
	int now;
	int root;
	scanf("%d", &n);

	for (int i = 0; i < n; i++)
	{
		vector<int> temp;
		arr.push_back(temp);
	}

	for (int i = 0; i < n; i++)
	{
		scanf("%d", &now);
		if (now != -1)
		{
			arr[now].push_back(i);
		}
		else
			root = i;
	}
	scanf("%d", &cut);
	arr[cut].clear();
	for (int i = 0; i < arr.size(); i++)
	{
		for (int j = 0; j < arr[i].size(); j++)
		{
			if (arr[i][j] == cut)
			{
				arr[i].erase(arr[i].begin() + j);
				break;
			}
		}
	}
	dfs(root);
	if (root == cut)
		cnt = 0;
	printf("%d", cnt);
}
