import math


def solution(dartResult):
    dartResult = dartResult.replace('10', 'x')   # 10인경우 대비해 str으로
    bonus = ['S', 'D', 'T']
    option = ['*', '#']
    score = []
    temp = 0
    for i in dartResult:
        if i.isnumeric():
            temp = int(i)
        elif i == 'x':
            temp = 10
        elif i in bonus:
            temp = int(math.pow(int(temp), bonus.index(i) + 1))
            score.append(temp)
        elif i in option:
            if i == '*':
                if len(score) > 1:
                    score[-2] = score[-2] * 2
                    score[-1] = score[-1] * 2
                else:
                    score[-1] = score[-1] * 2
            elif i == '#':
                score[-1] = score[-1] * -1
    return sum(score)


if __name__ == '__main__':
    print(solution('1S2D*3T'))
    print(solution('1D2S#10S'))
    print(solution('1D2S0T'))