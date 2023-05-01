/*
문제 : 크게 만들기
시간 : 30분
ide 활용 : x
질문 보기 : o
피드백 : 그리디 하게 그냥 되는 경우를 찾앗다.
현재 있는 곳에서 다음숫자가 작으면 제거하면서 하고
남은 부분을 최대한 뽑아나게 햇다.
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

int main(void)
{
	int n, k;
	string s;
	scanf("%d %d", &n, &k);
	cin >> s;
	int cnt = 0;
	vector<char> arr;
	for (int i = 0; i < s.size(); i++)
	{
		while (!arr.empty())
		{
			if (cnt >= k)
				break;
			if (s[i] <= arr.back())
				break;
			cnt++;
			arr.pop_back();
		}
		arr.push_back(s[i]);
	}
	while (cnt < k)
	{
		arr.pop_back();
		cnt++;
	}
	for (int i = 0; i < arr.size(); i++)
	{
		printf("%c", arr[i]);
	}
}
