n = 5
arr1 = [9, 20, 28, 18, 11]
arr2 = [30, 1, 21, 17, 28]

answer = []
arr1List = []
arr2List = []
for i in range(n):
        
    #bin :  십 -> 이 /  내장함수
    arr1List.append(bin(arr1[i])[2:])
    arr2List.append(bin(arr2[i])[2:])
    #print(arr1List )
    #  print("/")
    # print(arr2List)
    arr1List[i] = ('0' * (n-len(arr1List[i]))) + arr1List[i]
    arr2List[i] = ('0' * (n-len(arr2List[i]))) + arr2List[i]

    result = ''
    for j in range(n):
        if ((int)(arr1List[i][j]) + (int)(arr2List[i][j])) != 0:
            result += '#'
        else:
            result += ' '
    answer.append(result)

print(answer)