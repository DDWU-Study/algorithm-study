# 처음에 그냥 list로 받고 sort하면 되는거 아닌가 하고 메모리 초과 낭패 봄
import sys
import heapq


input = sys.stdin.readline
n = int(input())
heap = []

for i in range(n):
    nums = list(map(int, input().split()))
    for num in nums:
        if len(heap) < n:
            heapq.heappush(heap, num)
        elif heap[0] < num:
            heapq.heappushpop(heap, num)

print(heap[0])