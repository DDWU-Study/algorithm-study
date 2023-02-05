from collections import deque
import sys

input = sys.stdin.readline

# 건물 층수, 강호의 위치, 회사의 위치
f, s, g, u, d = map(int, input().split())
visited = [0] * (f + 1)
visited[s] = 1


def bfs():
    q = deque([s])
    while q:
        x = q.popleft()
        if x == g:
            print(visited[g] - 1)
            return

        up = x + u
        down = x - d
        if up <= f and not visited[up]:
            q.append(up)
            visited[up] = visited[x] + 1
        if 0 < down and not visited[down]:
            q.append(down)
            visited[down] = visited[x] + 1
    else:
        print('use the stairs')
        return

bfs()
