def solution(s):
    stack = []
    for i in s:
        stack.append(i)
        if len(stack) > 1 and stack[-1] == stack[-2]:
            stack.pop()
            stack.pop()
    return 0 if stack else 1


if __name__ == '__main__':
    print(solution('baabaa'))
    print(solution('cdcd'))