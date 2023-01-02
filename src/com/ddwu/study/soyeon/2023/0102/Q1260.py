from collections import deque


N, M, Start = map(int, input().split())  # 노드 개수, 에지 개수, 시작점
A = [[] for _ in range(N + 1)]

for _ in range(M):  # 인접 리스트에 그래프 데이터 저장
    v, e = map(int, input().split())
    A[v].append(e)
    A[e].append(v)


for i in range(N + 1):
    A[i].sort()  # 번호가 작은 노드부터 방문하기 위해 정렬하기


def DFS(v):
    print(v, end=' ')
    visited[v] = True
    for i in A[v]:
        if not visited[i]:
            DFS(i)


visited = [False] * (N + 1)
DFS(Start)


def BFS(v):
    queue = deque()
    queue.append(v)
    visited[v] = True
    while queue:
        now_node = queue.popleft()
        print(now_node, end=' ')
        for i in A[now_node]:
            if not visited[i]:
                visited[i] = True
                queue.append(i)

print()
visited = [False] * (N + 1)
BFS(Start)