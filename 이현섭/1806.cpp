/*
문제 : 부분합
시간 : 45
ide 활용 : x
질문 보기 : o
피드백 : 처음에 문제가 잘못 이해하여 질문을 보고 다시 풀었다.
투포인트를 사용하면서 엣지케이스에 대해 처리를 했줬다.
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
	vector<int> arr;
	int n, s;
	int now;
	int ans = 1999999999;
	scanf("%d %d", &n, &s);
	for (int i = 0; i < n; i++)
	{
		scanf("%d", &now);
		arr.push_back(now);
	}
	
	int i=0, j=0;
	int pl = 0;
	while (i>=j&&j<n)
	{
		if (pl < s&&i!=n)
		{
			pl += arr[i];
			i++;
		}
		else if(pl>=s)
		{
			pl -= arr[j];
			j++;
			ans = min(ans, i-j+1);
		}
		else
		{
			j++;
		}
	}

	if (ans == 1999999999)
		printf("0");
	else
		printf("%d", ans);
}
