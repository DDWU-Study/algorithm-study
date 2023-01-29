from collections import deque

MAX = 100001
n, k = map(int, input().split())
visited = [0] * MAX


def bfs(v):
    q = deque([v])

    while q:
        if v == k:
            return visited[v]
        for i in (v-1, v+1, 2*v):
            if 0 <= i < MAX and not visited[i]:
                visited[i] = visited[v] + 1
                q.append(i)
    print(q)

print(bfs(n))