from collections import defaultdict


def solution(survey, choices):
    personality_indicator = [('R', 'T'), ('C', 'F'), ('J', 'M'), ('A', 'N')]
    answer = ''
    personality_dic = defaultdict(int)
    for s, c in zip(survey, choices):
        if c < 4:
            personality_dic[s[0]] += (4 - c)
        elif c > 4:
            personality_dic[s[1]] += (c - 4)
    for i in personality_indicator:
        if personality_dic[i[0]] >= personality_dic[i[1]]:
            answer += i[0]
        else:
            answer += i[1]
    return answer


if __name__ == '__main__':
    survey = ["AN", "CF", "MJ", "RT", "NA"]
    choices = [5, 3, 2, 7, 5]
    print(solution(survey, choices))