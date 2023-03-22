import sys
input = sys.stdin.readline
from collections import deque


n, m = map(int, input().split())
graph = []
visited = [[-1 for _ in range(m)] for _ in range(n)]
r, c, d = map(int, input().split())     # d - 0: 북쪽, 1: 동쪽, 2: 남쪽, 3: 서쪽

# 0 3 2 1 순으로 돌아야 함
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

for _ in range(n):
    graph.append(list(map(int, input().split())))

visited[r][c] = 1
cnt = 1

while True:
    flag = True
    for _ in range(4):
        nx = r + dx[(d + 3) % 4]
        ny = c + dy[(d + 3) % 4]
        d = (d + 3) % 4
        if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] == 0:
            if visited[nx][ny] == 0:
                visited[nx][ny] = 1
                cnt += 1
                r = nx
                c = ny
                flag = False
                break

    if flag:
        if graph[r - dx[d]][c - dy[d]] == 1:  # 벽인 경우
            print(cnt)
            break
        else:
            r, c = r - dx[d], c - dy[d]