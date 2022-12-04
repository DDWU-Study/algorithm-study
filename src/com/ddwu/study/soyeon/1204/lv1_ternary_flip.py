def transfer_n_ary(n, q):
    rev_base = ''

    while n > 0:
        n, mod = divmod(n, q)
        rev_base += str(mod)

    return rev_base[::-1]


def solution(n):
    answer = transfer_n_ary(n, 3)
    return int(answer[::-1], 3)


if __name__ == '__main__':
    print(solution(45))
    print(solution(125))