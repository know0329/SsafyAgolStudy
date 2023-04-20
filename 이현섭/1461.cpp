/*
문제 : 도서관
시간 : 20분
ide 활용 : x
질문 보기 : X
피드백 : 양수, 음수로 일단 나눈다. 각각 배열을 소팅을 한다.
그리고 각 배열의 절대값의 제일 큰것을 골라서 먼저 다녀올 것을 정한다.
제일 먼거는 2배가 되면 안되기 때문에 제일 마지막에 한다.
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

int n, m;
int ans = 0;

void simul(vector<int> fir, vector<int> sec)
{
	int i = 0;
	for (int i = fir.size()-1 ; i >=0; i = i - m)
	{
		ans = ans + abs(fir[i] * 2);
	}
	int temp = sec[sec.size() - 1];
	for (int i = 0; i < m; i++)
	{
		if (sec.size() == 0)
			break;
		sec.pop_back();
	}
	for (int i = sec.size() - 1; i >= 0; i = i - m)
	{
		ans = ans + abs(sec[i] * 2);
	}
	ans += abs(temp);
}


int main(void)
{
	vector<int> pl;
	vector<int> mi;

	int now;
	int maxMi = 0;
	int maxPl = 0;
	scanf("%d %d", &n, &m);

	for (int i = 0; i < n; i++)
	{
		scanf("%d", &now);
		if (now > 0)
			pl.push_back(now);
		else
			mi.push_back(now);
	}

	sort(pl.begin(), pl.end());
	sort(mi.begin(), mi.end(), greater<int>());
	if(mi.size()!=0)
		maxMi = abs(*min_element(mi.begin(), mi.end()));//없으면 오류가 뜨네
	if (pl.size() != 0)
		maxPl = *max_element(pl.begin(), pl.end());

	if (maxMi > maxPl) 
	{
		simul(pl,mi);
	}
	else
	{
		simul(mi, pl);
	}
	printf("%d", ans);
}
