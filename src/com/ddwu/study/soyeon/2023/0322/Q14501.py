import sys
input = sys.stdin.readline

# 처음엔 문제가 이해가 안됨 왜 5일 이후로는 안된다는거지?
# 퇴사를 7일에 하는데 6, 7일차에는 각각 상담 소요일이 4, 2일이니까 퇴사일에 오버됨 -> 5일차에는 상담이 2일만 걸림 때문에 7일에 정확히 퇴사 가능

n = int(input())

D = [0] * (n + 2)
day = [0] * (n + 1)
income = [0] * (n + 1)

for i in range(1, n + 1):
    day[i], income[i] = map(int, input().split())

for i in range(n, 0, -1):
    if i + day[i] > n + 1:
        D[i] = D[i + 1]
    else:
        D[i] = max(D[i + 1], income[i] + D[i + day[i]])

print(D[1])