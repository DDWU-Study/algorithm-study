def solution(numbers):
    return sum([i for i in range(10) if i not in numbers])  #   return 45 - sum(numbers)


if __name__ == '__main__':
    numbers = [5, 8, 4, 0, 6, 7, 9]
    print(solution(numbers))