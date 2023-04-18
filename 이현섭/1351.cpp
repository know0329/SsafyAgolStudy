/*
문제 : 무한 수열
시간 : 40분
ide 활용 : o
질문 보기 : X
피드백 : 조금 더럽게 푼거 같긴 한데 먼저 arr에 n에서 p,q로 나누는 수를 넣는다.
그리고 map에도 넣는다.
그다음 arr의 값들을 돌면서 map의 인덱스에 접근해서 점화식느낌으로? 푼다.
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
long long n, p, q;

vector<long long> arr;
map<long long, long long > m;

void dfs(long long now) {
	if (m.count(now) == 1)
		return;
	if (now == 0)
		return;
	arr.push_back(now);
	m.insert(make_pair(now, 1));
	dfs(now / p);
	dfs(now / q);
}

int main(void)
{
	long long temp=n;
	scanf("%lld %lld %lld", &n, &p, &q);

	arr.push_back(0);
	m.insert(make_pair(0, 1));

	dfs(n);

	sort(arr.begin(), arr.end());
	arr.erase(unique(arr.begin(), arr.end()),arr.end());

	int ans = 1;
	for (int i = 1; i < arr.size(); i++)
	{
		m[arr[i]] = m[arr[i] / p] + m[arr[i] / q];
	}
	printf("%lld", m[n]);

}
