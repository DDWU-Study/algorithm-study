import sys
import collections
input = sys.stdin.readline

word = input().upper().strip()

counter = dict(collections.Counter(word).most_common())
if list(counter.values()).count(max(counter.values())) > 1:
    print('?')
else:
    print(next(iter(counter)))