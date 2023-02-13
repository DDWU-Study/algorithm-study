from collections import deque
import sys
input = sys.stdin.readline


# 입력
n, m = map(int, input().split())
direction = [(1, 0), (-1, 0), (0, 1), (0, -1)]  # 상하좌우
board = []
queue = deque([])
visited = [[False] * m for _ in range(n)]
res = [[-1] * m for _ in range(n)]

for i in range(n):
    row = list(map(int, input().split()))

    for j in range(m):
        if row[j] == 2:
            queue.append((i, j))
            visited[i][j] = True
            res[i][j] = 0

        if row[j] == 0:
            res[i][j] = 0
    board.append(row)

while queue:
    x, y = queue.popleft()

    for dx, dy in direction:
        nx, ny = x + dx, y + dy

        if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny] and board[nx][ny] == 1:
            queue.append((nx, ny))
            visited[nx][ny] = True
            res[nx][ny] = res[x][y] + 1

for row in res:
    for i in row:
        print(i, end=' ')
    print()