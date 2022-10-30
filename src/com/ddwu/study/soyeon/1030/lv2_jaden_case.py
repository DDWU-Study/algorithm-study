def solution(s):
    answer = []
    for j in s.split(' '):
        answer.append(j.lower().capitalize())
    return ' '.join(answer)


if __name__ == '__main__':
    print(solution("3people unFollowed me"))
    print(solution("for the last week"))