def solution(n):
    one_cnt = bin(n).count('1')
    for i in range(n+1, 1000001):
        if one_cnt == bin(i).count('1'):
            return i


if __name__ == '__main__':
    print(solution(78))
    print(solution(15))