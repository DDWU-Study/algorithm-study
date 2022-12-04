s = "baabaa"
stack=[]
for i in s:
    if not stack:
        stack.append(i)
    else:
        if(stack[-1]==i):
            stack.pop()
        else:
            stack.append(i)

if not stack:
    answer = 1
else:
    answer = 0

print(answer)



'''
#스택이용인걸 생각못하고 이상하게 풀기 시작
lens = len(s)
i=0
cnt=0
#for i in range(len(s)-1):
while True:
    print(i,"len(s)",s,"cnt",cnt)
    if(len(s)==0) or cnt >= lens or i == cnt:break
    if s[i] == s[i+1] or len(s)==0 :
        print("s[:i]",s[:i],"s[i+1:]",s[i+2:])
        s = s[:i] + s[i+2:]
        i=0
    else: i+=1
    
    cnt+=1
if len(s) == 0 : answer = 1
else : answer = 0

print(answer)'''