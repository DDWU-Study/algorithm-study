import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))
b, c = map(int, input().split())

arr = list(map(lambda x: x - b, arr))
supv = n

for a in arr:
    if a > 0:
        if a % c:
            supv += (a // c) + 1
        else:
            supv += (a // c)
print(supv)