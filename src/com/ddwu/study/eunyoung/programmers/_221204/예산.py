d = [1,3,2,5,4]
budget = 9

answer = 0
d.sort()
for i in range(len(d)):
    if budget-d[i] < 0:
        break
    budget=budget-d[i]
    answer=answer+1

print(answer)