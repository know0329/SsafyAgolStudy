/*
문제 :문자열 폭발
시간 : 20분
ide 활용 : o
질문 보기 : x
피드백 : temp 문자열에서 s2랑 크기가 같거나 커지면 계속 맨뒤를 비교하여 맞으면 pop시키고 
그렇게 풀었다.
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
	string s1;
	string s2;
	string temp;

	cin >> s1;
	cin >> s2;
	if (s1.size() < s2.size())
	{
		cout << s1;
	}
	else
	{
		for (int i = 0; i < s1.size(); i++)
		{
			if (temp.size() >= s2.size())
			{
				if (temp.substr(temp.size() - s2.size(), s2.size()) == s2)
				{
					for (int j = 0; j < s2.size(); j++)
					{
						temp.pop_back();
					}
				}
			}

			temp.push_back(s1[i]);
		}
		if (temp.substr(temp.size() - s2.size(), s2.size()) == s2)
		{
			for (int j = 0; j < s2.size(); j++)
			{
				temp.pop_back();
			}
		}
		if (temp.size() == 0)
			cout << "FRULA";
		else
			cout << temp;
	}

	
}
