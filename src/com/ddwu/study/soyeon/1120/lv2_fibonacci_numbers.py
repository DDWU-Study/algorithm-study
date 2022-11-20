def solution2(n):  # runtime error & timeout
    if n == 1 or n == 2:
        return 1
    else:
        return (solution2(n-1) + solution2(n-2)) % 1234567


def solution(n):
    answer = []
    for i in range(n+1):
        if i < 2:
            answer.append(i)
        else:
            fibo = answer[i-1] + answer[i-2]
            answer.append(fibo % 1234567)
    return answer[-1]


def solution3(n):  # other solution
    a, b = 0, 1
    for i in range(n):
        a, b = b, (a+b) % 1234567
    return a


if __name__ == '__main__':
    print(solution(3))
    print(solution3(3))
    print(solution(5))
    print(solution3(5))