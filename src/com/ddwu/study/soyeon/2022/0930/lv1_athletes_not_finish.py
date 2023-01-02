import collections


def solution(participant, completion):
    answer = collections.defaultdict(int)
    for par in participant:
        answer[par] += 1

    for com in completion:
        answer[com] -= 1

    for ans in answer:
        if answer[ans] > 0:
            return ans


def solution3(participant, completion):
    answer = ''
    temp = 0
    dic = {}
    for part in participant:
        dic[hash(part)] = part
        temp += int(hash(part))
    print(dic)
    for com in completion:
        temp -= hash(com)
    answer = dic[temp]

    return answer


def solution2(participant, completion):
    answer = participant.copy()
    for com in completion:
        if com in answer:
            answer.remove(com)

    return answer[0]        # 테스트케이스는 통과했으나 효율성 실패


def solution4(participant, completion):
    participant = set(participant)
    completion = set(completion)
    answer = participant.difference(completion)    # participant - completion
    return list(answer)[0]      # 테스트케이스 3에 어긋남 중복된 것들도 다 없앰


if __name__ == '__main__':
    participant = ["leo", "kiki", "eden"]
    completion = ["eden", "kiki"]
    print(solution(participant, completion))