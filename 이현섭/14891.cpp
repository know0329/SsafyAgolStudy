/*
문제 :톱니바퀴
시간 : 2시간
ide 활용 : x
질문 보기 : o
피드백 : 다른거는 생각을 잘햇는데 양쪽으로 뻗어나는 것을 못해서
다른 사람(현우형)의 설명을 참고했다. 
직접 돌리지 않고 계속 index를 갱신하면서 풀었다.
-8일떄는 초기화를 해줬는데
8일때 초기화를 안하니 틀렷다고 나왔다. 왜그런지는 몰루??

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

vector<string> arr;//n=0 s =1

int now[4] = { 0,0,0,0 };
int ch[4] = { 0,0,0, 0 };

int con(int n)
{
	if (n == -8)
		return 0;
	if (n == 8)
		return 0;
	else
		return n;
}
int conTwo(int nn)
{
	return (8 - now[nn] + 2) % 8;
}
int conSix(int nn)
{
	return (8 - now[nn] + 6) % 8;
}

void simul(int num,int dir)
{
	if (ch[num] == 1)
		return;

	ch[num] = 1;
	
	int left = num - 1;
	int right = num + 1;
	if (left >= 0 && left <= 3 && arr[num][conSix(num)] != arr[left][conTwo(left)])simul(left, dir * (-1));
	if (right >= 0 && right <= 3 && arr[right][conSix(right)] != arr[num][conTwo(num)])simul(right, dir * (-1));
	now[num] += dir;
	now[num] = con(now[num]);
}

int main(void) 
{
	string s;
	int num, dir;
	int k;
	int ans = 0;
	for (int i = 0; i < 4; i++)
	{
		cin >> s;
		arr.push_back(s);
	}
	scanf("%d", &k);

	for (int i = 0; i < k; i++)
	{
		int num, dir;
		scanf("%d %d", &num, &dir);
		num = num - 1;

		simul(num, dir);

		for (int j = 0; j < 4; j++)
		{
			ch[j] = 0;
		}

	}

	for (int i = 0; i < 4; i++)
	{
		int cc = (8 - now[i]) % 8;
		if (arr[i][cc] == '1')
			ans += (pow(2, i));
	}
	printf("%d", ans);
}
