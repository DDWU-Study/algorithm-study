answer = []
    
for i in range(len(absolutes)):
    if signs[i]:
        answer.insert(i, absolutes[i])
    else:
        answer.insert(i, -1 * absolutes[i])
        
return sum(answer)
