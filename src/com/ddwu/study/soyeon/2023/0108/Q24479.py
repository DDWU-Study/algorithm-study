import sys
sys.setrecursionlimit(10**9)
input = sys.stdin.readline


N, M, R = map(int, input().split())
A = [[] for _ in range(N + 1)]

for _ in range(M):
    u, v = map(int, input().split())
    A[u].append(v)
    A[v].append(u)  # 양방향 간선이므로


def dfs(v):
    global count
    visited[v] = count
    A[v].sort()
    for i in A[v]:
        if visited[i] == 0:
            count += 1
            dfs(i)


count = 1
visited = [0] * (N + 1)
dfs(R)

for i in range(1, N+1):
    print(visited[i])