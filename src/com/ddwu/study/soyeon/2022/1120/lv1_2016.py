def solution(a, b):
    days = ['FRI', 'SAT', 'SUN', 'MON', 'TUE', 'WED', 'THU']
    month = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    return days[(sum(month[:a - 1]) + b) % 7 - 1]


if __name__ == '__main__':
    print(solution(5, 24))
    print(solution(1, 1))