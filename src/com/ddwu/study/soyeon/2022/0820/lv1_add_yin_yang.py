def solution(absolutes, signs):
    answer = 0
    for absolute, sign in zip(absolutes, signs):
        if sign:
            answer += absolute
        else:
            answer -= absolute

    return answer


if __name__ == '__main__':
    absolutes = [4, 7, 12]
    signs = [True,  False, True]
    print(solution(absolutes, signs))