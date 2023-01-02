def solution(s):
    answer = []
    for i in range(1, len(s) + 1):
        temp_str = ''
        cnt = 1
        temp = s[:i]

        for j in range(i, len(s) + i, i):
            if temp == s[j: j + i]:
                cnt += 1
            else:
                if cnt > 1:
                    temp_str += str(cnt) + temp
                else:
                    temp_str += temp
                cnt = 1
                temp = s[j: j + i]
        answer.append(len(temp_str))
    return min(answer)


if __name__ == '__main__':
    s = "abcabcabcabcdededededede"
    print(solution(s))