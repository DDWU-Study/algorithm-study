
n=3
words=["tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"]

answer=[]
pre=[]
last=words[0][0]



cnt=0
for i in range(len(words)):
    '''if (i%n==0):
        cnt+=1
'''
    cnt=i//n+1
    turn = (i%n)+1


    first = words[i][0]
    if(last != first) or (words[i] in pre):
        answer.append(turn)
        answer.append(cnt)
        break

    pre.append(words[i])
    
    last = words[i][-1]

if not answer:
    answer.append(0)
    answer.append(0)
print(answer)


'''
위에랑 알고리즘은 똑같은데 훨짧음
for i in range(1,len(words)):
        if words[i] in words[:i] or words[i-1][-1] != words[i][0]:
            print( [(i%n)+1, (i//n)+1])
print([0,0])'''