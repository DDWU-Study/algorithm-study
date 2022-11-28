brown = 10
yellow = 2
answer = []

total = brown + yellow
for x in range(1,total) :
    y = total / x
    if (2*x+2*y-4 == brown):
        answer.append(y)
        answer.append(x)
        break
    
print(answer)