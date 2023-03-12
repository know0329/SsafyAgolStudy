/*
문제 : N과 M (5)
시간 : 10분
ide 활용 : x
질문 보기 : o
피드백 : nPr을 구하는 문제이다.
nPn은 구해봣지만 nPr은 또 처음이라 궁금해서 라이브러리를 활용하여 풀수 있는 방법을 찾앗다.
모든 nPn을 구하지만 그 뒤 내용을 reverse해서 다음 정리된 내용을 굳이 출력안하게 하는 방법이다

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
#include <math.h>

using namespace std;


int main(void)
{
	vector<int> arr;
	int temp;
	int n, m;

	scanf("%d %d", &n, &m);

	for (int i = 0; i < n; i++)
	{
		scanf("%d", &temp);
		arr.push_back(temp);
	}
	
	sort(arr.begin(), arr.end());

	do {
		for (int i = 0; i < m; i++)
		{
			printf("%d ", arr[i]);
		}
		printf("\n");
		reverse(arr.begin() + m, arr.end());
		/*printf("\nR");
		reverse(arr.begin() + m, arr.end());
		for (int i = 0; i < n; i++)
		{
			printf("%d ", arr[i]);
		}
		printf("\n");*/
	} while (next_permutation(arr.begin(), arr.end()));

}
