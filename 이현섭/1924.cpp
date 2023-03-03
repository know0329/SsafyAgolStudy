/*
문제 :무선 충전
시간 : 3시간?
ide 활용 : o
질문 보기 : o
피드백 : 먼저 3차원 배열로 map을 그리고 a,b가 움직이면서 확인을 했다.
그래서 a위치일 때 0,1, 2이상일 때 경우의 수를 모두 나눠서 b위치에서 0,1,2이상 경우의 수를 나눴다.
그래서 9가지 경우의 수에 대응함.
제일 어려운 a,b둘다 2 이상일때 처리가 제일 힘들었다. 어떻게 해야할지 여러 방법을 했는데
결국 모든 조합에서 2개를 뽑아 제일 큰값을 뽑게 했다. 
질문은 다른사람들이 틀리는 경우의 수를 봣는데 애초에 초기 input부터 계속 틀리고 초기 input이 맞으니 그냥 통과 됐다.
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
