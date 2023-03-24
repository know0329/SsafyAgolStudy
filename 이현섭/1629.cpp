/*
문제 : 곱셈
시간 : 1시간
ide 활용 : x
질문 보기 : x
피드백 : 알고리즘 생각은 빨리 했다. 근데 구현을 못해서 오래걸렷다.
일단 b의 숫자에 따라 /2 나누면서 1,2일때 return해서 답이 나오게 했따.

f(6) = (f(n/2) * f(n/2+1)) %c
f(3) = (f(2) * f(1))%c

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

long long a, c;

long long ans;

long long dfs(long long b)
{
	if (b == 1)
		return a % c;
	if (b == 2)
		return (a*a) % c;
	if (b % 2 == 1)
	{
		return (dfs(b / 2)*dfs(b / 2 + 1))%c;
	}
	if (b % 2 == 0){

		return (dfs(b / 2)*dfs(b / 2))%c;
	}
}

int main(void)
{
	int T;
	int n,m;
	int b;

	cin >> a >> b >> c;
	//dfs(b);
	cout<< dfs(b);
}
