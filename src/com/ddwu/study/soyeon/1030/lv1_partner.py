def solution2(X, Y):
    answer = []
    Y = list(Y)
    for x in X:
        if x in Y:
            answer.append(x)
            Y.remove(x)

    if len(answer) == 1:
        return '-1'
    elif answer[0] == 0:
        return '0'
    else:
        return ''.join(sorted(answer, reverse=True))


def solution(X, Y):
    answer = []
    for i in (set(X) & set(Y)): # 교집합
        for j in range(min(X.count(i), Y.count(i))):
            answer.append(i)
    answer.sort(reverse=True)
    if len(answer) == 0:
        return '-1'
    if answer[0] == '0':
        return '0'
    return ''.join(answer)


if __name__ == '__main__':
    print(solution("100", "2345"))
    print(solution("100", "203045"))
    print(solution("100", "123450"))
    print(solution("12321", "42531"))
    print(solution("5525", "1255"))