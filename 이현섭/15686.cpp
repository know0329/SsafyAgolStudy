/*
문제 : 치킨 배달
시간 : 60분
ide 활용 : x
질문 보기 : x
피드백 : 치킨집과 그냥 집을 저장하고 치킨집을 고르는 조합을 뽑아냇다.
뽑아낸 조합을 가지고 각각의 집의 치킨거리를 계산했고 그 조합중 최솟값을 출력했다.
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

int arr[51][51];

int main(void)
{
	int n, m;
	int ans = 99999;
	scanf("%d %d", &n, &m);
	vector<pair<int, int>> house;//집 저장
	vector<pair<int, int>> chicken;//치킨 집 저장

	vector<int> vit;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			scanf("%d", &arr[i][j]);
			if (arr[i][j] == 1)
			{	
				house.push_back(make_pair(j,i));
			}

			if (arr[i][j] == 2)
			{
				chicken.push_back(make_pair(j, i));
				vit.push_back(0);
			}
		}
	}
	for (int i = 0; i < m; i++)
	{
		vit[i] = 1;
	}

	do {
		vector<pair<int, int>> temp;
		vector<int> minNum(house.size(),99999);//조합으로 뽑힌 치킨집와 집의 거리최소값을 저장하는 배열
		int minAns = 0;//조합으로 뽑힌 치킨거리값
		for (int i = 0; i < vit.size(); i++)
		{
			if(vit[i]==1)
				temp.push_back(make_pair(chicken[i].first, chicken[i].second));//어디 치킨집을 고름
		}

		for (int i = 0; i < temp.size(); i++)
		{
			for (int j = 0; j < house.size(); j++)
			{
				minNum[j] = min((abs(temp[i].first - house[j].first) + abs(temp[i].second - house[j].second)), minNum[j]);
			}
		}
		for (int i = 0; i < minNum.size(); i++)
		{
			minAns += minNum[i];
		}
		ans = min(ans, minAns);
	} while (prev_permutation(vit.begin(), vit.end()));

	printf("%d", ans);
}
