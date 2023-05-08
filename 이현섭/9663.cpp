/*
문제 : N-Queen
시간 : 20분
ide 활용 : x
질문 보기 : o
피드백 : 바킹독 강의를 들으면서 풀엇던 것으로 햇다.
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

bool isused1[40]; // column을 차지하고 있는지
bool isused2[40]; // / 방향 대각선을 차지하고 있는지
bool isused3[40]; // \ 방향 대각선을 차지하고 있는지

int cnt = 0;
int n;
void func(int cur) { 
	if (cur == n) { 
		cnt++;
		return;
	}
	for (int i = 0; i < n; i++) {
		if (isused1[i] || isused2[i + cur] || isused3[cur - i + n - 1]) 
			continue;
		isused1[i] = 1;
		isused2[i + cur] = 1;
		isused3[cur - i + n - 1] = 1;
		func(cur + 1);
		isused1[i] = 0;
		isused2[i + cur] = 0;
		isused3[cur - i + n - 1] = 0;
	}
}
int main(void) {

	cin >> n;
	func(0);
	cout << cnt;
}
