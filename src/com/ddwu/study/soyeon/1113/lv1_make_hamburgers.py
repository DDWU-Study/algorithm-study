def solution2(ingredient):  # 시간 초과
    answer = 0
    ingredient = ''.join(list(map(str, ingredient)))
    for i in range(len(ingredient)):
        if '1231' in ingredient:
            answer += 1
            ingredient = ingredient.replace('1231', '')
    return answer


def solution(ingredient):
    stack = []
    answer = 0
    for i in ingredient:
        stack.append(i)
        if stack[-4:] == [1, 2, 3, 1]:
            answer += 1
            for _ in range(4):
                stack.pop()
    return answer


if __name__ == '__main__':
    print(solution([2, 1, 1, 2, 3, 1, 2, 3, 1]))
    print(solution([1, 3, 2, 1, 2, 1, 3, 1, 2]))
