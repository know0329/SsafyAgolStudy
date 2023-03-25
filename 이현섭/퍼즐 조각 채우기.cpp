/*
문제 : 퍼즐 조각 채우기
시간 : 3시간
ide 활용 : o
질문 보기 : x
피드백 : 너무 길다... 음...
bfs를 이용햇는데 그냥 구현이것 같다.
일단 game board의 텅빈 좌표를 저장한다.
그 다음 table의 1인 좌표를 저장한다. 그 다음 table을 회전시켜 그 좌표도 저장한다.
회전 시키기 전에 table의 각 퍼즐마다 index를 줘서 회전시켜도 그 index에 저장시키게 한다.
위에 좌표를 저장 할때는 sort를 해서 좌표가 들어오는 순서와 상관없이 똑같이 저장시킨다.
그 다음 모든 경우의 수를 비교하면서 모든 좌표가 같다면 answer++를 시킨다.
이런 문제도 빨리 풀어야할거 같은데 시간이 너무 오래걸린다. 구현실력이 안좋은 것도 있고 struct를 sort할 떄 무조건 compare를 포함시켜야하는 사실을 이제 알았따.

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

typedef struct Cood {
    int x, y;
    Cood(int _x, int _y) : x(_x), y(_y) {}
}Cood;
bool compare(Cood a, Cood b)
{
    if (a.x == b.x) {
        return a.y < b.y;
    }
    else {
        return a.x < b.x;
    }
}
vector<vector<vector<Cood>>> tableCood;//모든 table 좌표가 잇는 벡터
int dx[4] = { 1,0,-1,0 };
int dy[4] = { 0,1,0,-1 };//동남서북 0,1,2,3
int vit[51][51];
int vitTable[51][51];
int n;

vector<vector<int>> rotation(vector<vector<int>> table, vector<vector<int>> temp) {
    

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            temp[i][j] = table[j][n - i -1];
        }
    }
    return temp;
}

void init()
{
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            vitTable[i][j] = 0;
        }
    }
}

void findTableCood(vector<vector<int>> tempTable)
{
    int index = 0;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if (tempTable[i][j] != 0 && vitTable[i][j] == 0)//table 기본 좌표들 구하기
            {
                index = tempTable[i][j];
                vector<Cood> tempCood;
                queue<Cood> q;
                vitTable[i][j] = 1;
                q.push(Cood(j, i));
                while (!q.empty())
                {
                    int x = q.front().x;
                    int y = q.front().y;
                    tempCood.push_back(Cood(x - j, y - i));//그냥 최소한의 좌표로 고정하기위해
                    q.pop();
                    for (int k = 0; k < 4; i - k++)
                    {
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= n || vitTable[ny][nx] == 1)
                            continue;
                        if (tempTable[ny][nx] == 0)
                            continue;
                        q.push(Cood(nx, ny));
                        vitTable[ny][nx] = 1;
                    }
                }
                sort(tempCood.begin(), tempCood.end(), compare);
                tableCood[index - 1].push_back(tempCood);
            }
        }
    }
}


int solution(vector<vector<int>> game_board, vector<vector<int>> table) {
    int answer = 0;
    n = game_board.size();
    int index = 1;
    vector<vector<Cood>> gameCood;

    vector<vector<int>> table90;
    vector<vector<int>> table180;
    vector<vector<int>> table270;

    for (int i = 0; i < n; i++)
    {
        vector<int> temp(n);
        table90.push_back(temp);
        table180.push_back(temp);
        table270.push_back(temp);
    }

    //game board의 모형 구하기
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if (game_board[i][j] == 0&&vit[i][j]==0)
            {
                vector<Cood> tempCood;
                queue<Cood> q;
                vit[i][j] = 1;
                q.push(Cood(j, i));
                while (!q.empty())
                {
                    int x = q.front().x;
                    int y = q.front().y;
                    tempCood.push_back(Cood(x-j, y-i));//그냥 최소한의 좌표로 고정하기위해
                    q.pop();
                    for (int k = 0; k < 4;k++)
                    {
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= n || vit[ny][nx] == 1)
                            continue;
                        if (game_board[ny][nx] == 1)
                            continue;
                        q.push(Cood(nx, ny));
                        vit[ny][nx] = 1;
                    } 
                }
                sort(tempCood.begin(), tempCood.end(), compare);
                gameCood.push_back(tempCood);
            }
        }
    }

    //table의 모형 구하기
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if (table[i][j] == 1 && vitTable[i][j] == 0)//table 기본 좌표들 구하기
            {
                vector<Cood> tempCood;
                vector<vector<Cood>> tableOneCood;
                queue<Cood> q;
                vitTable[i][j] = 1;
                q.push(Cood(j, i));
                while (!q.empty())
                {
                    int x = q.front().x;
                    int y = q.front().y;
                    tempCood.push_back(Cood(x - j, y - i));//그냥 최소한의 좌표로 고정하기위해
                    table[y][x] = index;
                    q.pop();
                    for (int k = 0; k < 4; k++)
                    {
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= n || vitTable[ny][nx] == 1)
                            continue;
                        if (table[ny][nx] == 0)
                            continue;
                        q.push(Cood(nx, ny));
                        vitTable[ny][nx] = 1;
                    }
                }
                sort(tempCood.begin(), tempCood.end(), compare);
                tableOneCood.push_back(tempCood);
                tableCood.push_back(tableOneCood);

                index++;//각각의 그림이 무엇인지 확인
            }

        }
    }

    init();
    table90 = rotation(table,table90);
    //90도 돌린 table에서 좌표 구하기
    findTableCood(table90);

    init();
    table180 = rotation(table90, table180);
    //180도 돌린 table에서 좌표 구하기
    findTableCood(table180);

    init();
    table270 = rotation(table180,table270);
    //270도 돌린 table에서 좌표 구하기
    findTableCood(table270);

    for (int i = 0; i < tableCood.size(); i++)
    {
        int flag = 0;
        for (int j = 0; j < tableCood[i].size(); j++)
        {
            for (int k = 0; k < tableCood[i][j].size(); k++)
            {
                for (int l = 0; l < gameCood.size(); l++)
                {
                    if (tableCood[i][j].size() == gameCood[l].size())
                    {
                        int cnt = 0;
                        int m;
                        for (m = 0; m < gameCood[l].size(); m++)
                        {
                            if (tableCood[i][j][m].x != gameCood[l][m].x ||
                                tableCood[i][j][m].y != gameCood[l][m].y)
                            {
                                break;
                            }
                            cnt++;
                        }
                        if (m==gameCood[l].size())
                        {
                            gameCood[l].clear();
                            tableCood[i].clear();
                            answer += cnt;
                            break;
                        }  
                    }
                }
                if (tableCood[i].size() == 0)
                    break;
            }
            if (tableCood[i].size() == 0)
                break;
        }
    }

    return answer;
}
int main(void)
{
    printf("%d", solution({ {1, 1, 0, 0, 1, 0},{0, 0, 1, 0, 1, 0},{0, 1, 1, 0, 0, 1},{1, 1, 0, 1, 1, 1},{1, 0, 0, 0, 1, 0},{0, 1, 1, 1, 0, 0} }
    , { {1, 0, 0, 1, 1, 0},{1, 0, 1, 0, 1, 0},{0, 1, 1, 0, 1, 1},{0, 0, 1, 0, 0, 0},{1, 1, 0, 1, 1, 0},{0, 1, 0, 0, 0, 0} }));
}
