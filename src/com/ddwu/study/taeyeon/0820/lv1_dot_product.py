a = [1,2,3,4]
b = [-3,-1,0,2]

answer = []

for i in range(len(a)):
    answer.insert(i, a[i]*b[i])

print(sum(answer))
