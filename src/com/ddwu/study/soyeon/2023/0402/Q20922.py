import sys
input = sys.stdin.readline

n, k = map(int, input().split())
arr = list(map(int, input().split()))

ans = 0
left, right = 0, 0
cnt = [0] * (max(arr) + 1)

while right < n:
    if cnt[arr[right]] < k:
        cnt[arr[right]] += 1
        right += 1
    else:
        cnt[arr[left]] -= 1
        left += 1
    ans = max(ans, right - left)

print(ans)