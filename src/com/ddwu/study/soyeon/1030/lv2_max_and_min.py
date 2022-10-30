def solution(s):
    answer = []
    for i in s.split(' '):
        answer.append(int(i))
    return '{0} {1}'.format(min(answer), max(answer))


if __name__ == '__main__':
    print(solution("1 2 3 4"))
    print(solution("-1 -2 -3 -4"))
    print(solution("-1 -1"))