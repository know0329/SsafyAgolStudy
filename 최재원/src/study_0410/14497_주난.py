from collections import deque

# 입력
row, col = map(int, input().split())
start_y, start_x, end_y, end_x = map(int, input().split())
board = [list(map(str, input().strip())) for _ in range(row)]

# *에 도착하기까지, 1을 몇번 지나는지.
# dis 배열 : 해당 좌표까지 지나가는 1의 개수
# 점프 -> 0이면 이전 값, 1이면 이전 값 +1 
dis = [[-1 for _ in range(col)] for _ in range(row)]
# 배열 범위 0 ~ row/col 이므로 -1
dis[start_y-1][start_x-1] = 0
# 상하좌우
dxdy = [[1,0], [-1,0], [0,1], [0,-1]]

# bfs
dq = deque()
dq.append((start_y-1,start_x-1))
while dq:
    y, x = dq.popleft()
    for i in range(4):
        ny, nx = y + dxdy[i][0], x + dxdy[i][1]
        # 범위 안 벗어나고, -1일 때
        if 0 <= ny < row and 0 <= nx < col and dis[ny][nx] == -1:
            # 다음 좌표가 0 -> dq 왼쪽에 삽입해 먼저 탐색
            if board[ny][nx] == '0':
                dq.appendleft((ny,nx))
                dis[ny][nx] = dis[y][x]
            # 다음 좌표가 1 -> dq 오른쪽에 삽입해 늦게 탐색
            else:
                dq.append((ny,nx))
                dis[ny][nx] = dis[y][x] + 1

print(dis[end_y-1][end_x-1])