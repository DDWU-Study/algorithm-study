s="A B"
n = 3
print(s)
s = list(s)
print(s)
#ord 함수 : 문자 -> 아스키코드
#chr : 아스키 -> 문자
for i in range(0,len(s)):
    if s[i].isupper():
        s[i] = chr((ord(s[i]) - ord('A') + n) % 26 + ord('A'))
        
    elif s[i].islower():
        s[i] = chr((ord(s[i]) - ord('a') + n) % 26 + ord('a'))
    else :
        print("공백?"+ s[i])
        continue
        
    # print("s :"+s)
    print("s[i] : "+ s[i])
    #join 함수 : 리스트를 한번에 문자열로 변환
print("".join(s))