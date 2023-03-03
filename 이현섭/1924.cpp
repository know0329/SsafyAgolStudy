/*
문제 :2007년
시간 : 5분
ide 활용 : x
질문 보기 : x
피드백 : 현재월보다 낮은 만틈 일수를 더해주고 계산했다.
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

int arr[13];

int main(void)
{
	int x, y;

	scanf("%d %d", &x, &y);

	int ans = -1;

	arr[1] = 31;
	arr[2] = 28;
	arr[3] = 31;
	arr[4] = 30;
	arr[5] = 31;
	arr[6] = 30;
	arr[7] = 31;
	arr[8] = 31;
	arr[9] = 30;
	arr[10] = 31;
	arr[11] = 30;
	arr[12] = 31;

	for (int i = 1; i < x; i++)
	{
		ans += arr[i];
	}
	ans += y;

	if ((ans % 7) + 1 == 1)
		printf("MON");
	else if ((ans % 7) + 1 == 2)
		printf("TUE");
	else if ((ans % 7) + 1 == 3)
		printf("WED");
	else if ((ans % 7) + 1 == 4)
		printf("THU");
	else if ((ans % 7) + 1 == 5)
		printf("FRI");
	else if ((ans % 7) + 1 == 6)
		printf("SAT");
	else
		printf("SUN");


}
