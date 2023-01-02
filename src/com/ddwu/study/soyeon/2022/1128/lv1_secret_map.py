def solution(n, arr1, arr2):
    answer = []
    for one, two in zip(arr1, arr2):
        temp = ''
        one = bin(one)[2:].zfill(n)
        two = bin(two)[2:].zfill(n)
        for i in range(n):
            if one[i] == '0' and two[i] == '0':
                temp += ' '
            else:
                temp += '#'
        answer.append(temp)
    return answer


if __name__ == '__main__':
    print(solution(5, [9, 20, 28, 18, 11], [30, 1, 21, 17, 28]))
    print(solution(6, [46, 33, 33, 22, 31, 50], [27, 56, 19, 14, 14, 10]))