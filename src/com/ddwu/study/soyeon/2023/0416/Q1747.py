# 소수 & 팰린드롬
import sys
import math

input = sys.stdin.readline


def is_prime(x):
    if x == 1:
        return False
    for i in range(2, int(math.sqrt(x)) + 1):
        if x % i == 0:
            return False
    return True


def is_palindrome(x):
    str_x = str(x)
    return str_x == str_x[::-1]


n = int(input())

while n <= 1050000:     # n이 1000000인 경우도 고려해야 하기 때문
    if is_prime(n) and is_palindrome(n):
        print(n)
        break
    n += 1