import sys
from collections import deque

input = sys.stdin.readline

# n-도시의 개수, m-도로의 개수, k-거리 정보, x-출발 도시의 정보
n, m, k, x = map(int, input().split())
graph = [[] for _ in range(n + 1)]

for _ in range(m):
    u, v = map(int, input().split())
    graph[u].append(v)  # 단방향

distance = [0] * (n + 1)
visited = [False] * (n + 1)


def bfs(v):
    answer = []
    queue = deque([v])
    visited[v] = True
    distance[v] = 0

    while queue:
        v = queue.popleft()
        for i in graph[v]:
            if not visited[i]:
                visited[i] = True
                queue.append(i)
                distance[i] = distance[v] + 1
                if distance[i] == k:
                    answer.append(i)
    if len(answer) == 0:
        print(-1)
    else:
        answer.sort()
        for i in answer:
            print(i, end='\n')


bfs(x)