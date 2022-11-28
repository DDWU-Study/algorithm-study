n = 78
cnt =0 

'''
newN = str(bin(n)[2:])

for i in range(len(newN)):
    print(newN[i])
    if newN[i] == '1' :
        cnt = cnt+ 1

print("cnt")
print( cnt)

'''
cnt = bin(n).count('1')
print( cnt)
while True:
    n = n + 1                          
    if cnt == bin(n).count('1'):   
        break
    
print(n) 