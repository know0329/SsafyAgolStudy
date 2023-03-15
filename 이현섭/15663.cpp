/*
문제 : N과 M (9)
시간 : 3분
ide 활용 : x
질문 보기 : x
피드백 : 순열을 구한다.
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
		reverse(arr.begin()+m, arr.end());
	} while (next_permutation(arr.begin(), arr.end()));

}
