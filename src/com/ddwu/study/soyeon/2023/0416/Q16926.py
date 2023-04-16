# 배열 회전하기 1
# 달팽이 모양처럼 유기적으로 돌아가는 것이 아닌, 레이어(층) 끼리 회전하는 것!
# https://velog.io/@leetaekyu2077/%EB%B0%B1%EC%A4%80-16926%EB%B2%88-%EB%B0%B0%EC%97%B4-%EB%8F%8C%EB%A6%AC%EA%B8%B0-1
from sys import stdin
from collections import deque

N, M, R = map(int, stdin.readline().split())

matrix = []
answer = [[0]*M for _ in range(N)]
deq = deque()

for i in range(N):
    matrix.append(list(stdin.readline().split()))

loops = min(N, M) // 2
for i in range(loops):
    deq.clear()
    deq.extend(matrix[i][i:M-i])
    deq.extend([row[M-i-1] for row in matrix[i+1:N-i-1]])
    deq.extend(matrix[N-i-1][i:M-i][::-1])
    deq.extend([row[i] for row in matrix[i+1:N-i-1]][::-1])

    deq.rotate(-R)

    for j in range(i, M-i):                 # 위쪽
        answer[i][j] = deq.popleft()
    for j in range(i+1, N-i-1):             # 오른쪽
        answer[j][M-i-1] = deq.popleft()
    for j in range(M-i-1, i-1, -1):           # 아래쪽
        answer[N-i-1][j] = deq.popleft()
    for j in range(N-i-2, i, -1):           # 왼쪽
        answer[j][i] = deq.popleft()

for line in answer:
    print(" ".join(line))