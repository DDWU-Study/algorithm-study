import math


def is_prime_number(x):
    for i in range(2, int(math.sqrt(x)) + 1):
        if x % i == 0:
            return False  # 소수가 아님
    return True  # 소수


def solution(n):
    answer = 0
    for i in range(2, n + 1):
        if is_prime_number(i):
            answer += 1
    return answer


if __name__ == '__main__':
    print(solution(10))
    print(solution(5))