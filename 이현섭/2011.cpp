/*
문제 : 암호코드
시간 : 2시간30분
ide 활용 : x
질문 보기 : o
피드백 : 점화식 자체는 빨리 구했다.
그런데 0일때 경우의 수를 하나씩 쳐내다 보니 코드가 더러워졋다.
한 한시간동안 33인 경우를 0이 나와서 틀렷다.
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

int dp[5001];

int main(void)
{
	string s;
	cin >> s;
	map<string, int> m;
	for (int i = 1; i <= 26; i++)
	{	
		m.insert(make_pair(to_string(i), 1));
	}

	if (s[0] >= '1' && s[0] <= '9')
		dp[0] = 1;
	if (s[1] >= '1' && s[1] <= '9')
		dp[1] = 1;
	string temp;
	temp.push_back(s[0]);
	temp.push_back(s[1]);

	if (m.count(temp) == 1)
		dp[1]++;
	else if(s[0]=='0')
		dp[1] = 0;

	temp.clear();

	int zero = 0;
	for (int i = 2 ;i <s.size(); i++)
	{
		if (s[i - 1] == '0')
		{
			zero++;
			dp[i] = dp[i - 1];
			if (zero == 2)
			{
				dp[s.size() - 1] = 0;
				break;
			}
		}
		else
		{
			zero = 0;
			if (s[i] >= '1' && s[i] <= '9')
			{
				if (dp[i - 1] != 0)
					dp[i] += dp[i - 1];
			}
			temp.push_back(s[i - 1]);
			temp.push_back(s[i]);
			if (m.count(temp) == 1)
				dp[i] += dp[i - 2];
		}
		dp[i] = dp[i] % 1000000;
		temp.clear();
	}

	printf("%d", dp[s.size()-1]);

}
