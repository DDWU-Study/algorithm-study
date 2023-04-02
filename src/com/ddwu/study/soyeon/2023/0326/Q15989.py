import sys
input = sys.stdin.readline

# '합을 이루고 있는 수의 순서만 다른 것은 같은 것으로 친다' 를 간과함
# 1만 써서 합 되는 경우 = 1
# 1 - 1
# 2 - 1+1; 2
# 3 - 1+1+1; 2+1; 3 -> 2의 경우에 3 추가
# 4 - 1+1+1+1; 2+2; 2+1+1; 3+1 --> 3의 경우에 2 추가
# 5 - 1+1+1+1+1; 1+1+1+2; 2+2+1; 2+3; 1+1+3 --> 4의 경우에 2 추가 3 추가 (2 + 3)
# 6 - 1+1+1+1+1+1; 1+1+2+2; 1+1+1+1+2; 1+2+3; 1+1+1+3; 2+2+2; 3+3

t = int(input())

dp = [1] * 10001

for i in range(2, 10001):
    dp[i] += dp[i - 2]

for i in range(3, 10001):
    dp[i] += dp[i - 3]

for _ in range(t):
    print(dp[int(input())])