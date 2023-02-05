def solution(n):
    if n == 1:
        return 1
    elif n == 2:
        return 2
    else:
        a, b = 1, 2
        for i in range(n - 2):
            a, b = b, a + b
        return b % 1234567
    # 3
    # 1 1 1
    # 2 1
    # 1 2
    # f(n) = f(n-1) + f(n-2)