def solution(s):
    answer = [0, 0]
    while s != '1':
        answer[1] += s.count('0')
        s = bin(len(s.replace('0', '')))[2:]
        answer[0] += 1
    return answer


if __name__ == '__main__':
    print(solution("110010101001"))
    print(solution("01110"))
    print(solution("1111111"))
