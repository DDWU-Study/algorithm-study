n = 45
result = 7

tmp=[]

while n :
    n,m = divmod(n,3)
    tmp.append(str(m))

print(tmp)
#tmp.reverse()
#print(tmp)

three = "".join(tmp)
print(three)
answer = int(three,3)
print(answer)
