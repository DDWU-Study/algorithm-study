import sys
input = sys.stdin.readline

arr = [0, 1]
n = int(input())
for i in range(2, n+1):
    arr.append(arr[-1] + arr[-2])
    
print(arr[n])
