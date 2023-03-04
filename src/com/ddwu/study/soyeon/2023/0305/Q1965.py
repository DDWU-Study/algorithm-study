import sys
input = sys.stdin.readline

n = int(input())
box = list(map(int, input().split()))
dp = [1 for _ in range(n)]

for i in range(1, n):
    for j in range(i):
        if box[i] > box[j]:  # 뒤에 있는 상자가 앞에 있는 상자보다 큰 경우
            dp[i] = max(dp[i], dp[j] + 1)

print(max(dp))