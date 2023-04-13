# 0이 N극, 1이 S극.
# 1이 시계 방향, -1이 반시계 방향.

import math
# 톱니 시계 방향으로 회전
def rotate_Clock(str):
    temp = str[7]
    for i in range(6,-1,-1):
        str[i+1] = str[i]
    str[0] = temp

# 톱니 반시계 방향으로 회전
def rotate_CounterClock(str):
    temp = str[0]
    for i in range(7):
        str[i] = str[i+1]
    str[7] = temp

# 좌우 방향에 위치한 톱니와 비교
def dfs(i, dir):
    global visited
    if not visited[i]:
        visited[i] = True
        left = graph[i][6]
        right = graph[i][2]
        if dir == 1: 
            rotate_Clock(graph[i])
        else: 
            rotate_CounterClock(graph[i])
        # 현재 톱니와 다른 극이면, 반대 방향으로 회전.
        if i-1 >= 1 and left != graph[i-1][2]: 
            dfs(i-1, -dir)
        if i+1 <= 4 and right != graph[i+1][6]: 
            dfs(i+1, -dir)
        

# graph = [input() for _ in range(4)]
graph = [[]]
for _ in range(4):
    graph.append(list(input().rstrip()))
K = int(input())
for _ in range(K):
    # n번째 톱니바퀴를, dir 방향으로 회전시킴.
    n, dir = map(int, input().split())
    # print("오른쪽 :" + graph[n][2])
    # print("왼쪽 : " + graph[n][6])
    visited = [False] * 5
    dfs(n,dir)

# 각 톱니의 0번 위치가 1이면, 점수 추가
ans  = 0
for k in range(1,5):
    s = math.pow(2, k-1)
    if graph[k][0]=='1': 
        ans += s
print(int(ans))