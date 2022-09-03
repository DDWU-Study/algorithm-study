# -*- coding: utf-8 -*-
"""lv2_queue_sum_make_same.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1kB5DwNhGRRDUN0YvOnoG0eFG7S7LSFlO
"""

queue1 = [3, 2, 7, 2]	
queue2 = [4, 6, 5, 1]	
answer = -2

from collections import deque

queue1 = deque(queue1)
queue2 = deque(queue2)

print(queue1, queue2)

q1_sum = sum(queue1)
half_sum = (q1_sum + sum(queue2)) // 2
print(half_sum)

cnt = 0
while queue1 and queue2:
  if q1_sum == half_sum:
    print(cnt)
    break
  elif q1_sum > half_sum:
    q1_sum -= queue1.popleft()
    print(q1_sum)
  else:
    queue1.append(queue2.popleft())
    q1_sum += queue1[-1]
    print(q1_sum, queue1)
  cnt += 1

print(cnt)