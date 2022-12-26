def solution(n):
    ans = 1
    while n != 1:
        if n % 2 == 0:
            n //= 2
        else:
            ans += 1
            n -= 1
    return ans


if __name__ == '__main__':
    print(solution(5))  # 2
    print(solution(6))  # 2
    print(solution(5000))   # 5