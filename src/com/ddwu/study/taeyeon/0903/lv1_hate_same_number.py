# -*- coding: utf-8 -*-
"""lv1_hate_same_number.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1Gq4-W6xUOixMwYpGIUAW709q_KmVyPb0
"""

arr = [1,1,3,3,0,1,1]

answer = []
answer.append(arr[0])
j = 0
for i in range(1, len(arr)):
  if answer[j] != arr[i]:
    answer.append(arr[i])
    j+=1
    print(arr[i])
print(answer)