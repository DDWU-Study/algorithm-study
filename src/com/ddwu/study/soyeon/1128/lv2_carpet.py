def get_divisor(n):
    divisor_list = []
    for i in range(1, int(n**(1/2)) + 1):
        if n % i == 0:
            divisor_list.append(i)
            if i ** 2 != n:
                divisor_list.append(n // i)
    return sorted(divisor_list)


def solution(brown, yellow):
    answer = []
    total = brown + yellow
    for b in range(1, total+1):
        if (total / b) % 1 == 0:
            a = total // b
            if a >= b:
                if 2*a + 2*b == brown + 4:
                    return [a, b]
    return answer


if __name__ == '__main__':
    print(solution(10, 2))
    print(solution(8, 1))
    print(solution(24, 24))