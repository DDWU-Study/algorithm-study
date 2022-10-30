from collections import defaultdict


def solution2(N, stages):
    users = len(stages)
    user_stages = defaultdict(int)
    for stg in range(1, N+1):
        user_stages[stg] += stages.count(stg)
    user_stages = dict(sorted(user_stages.items()))

    answer = defaultdict(float)
    for k, v in user_stages.items():
        if k == (N + 1):
            answer[N] = 0.0
            break
        answer[k] = v / users
        users -= v

    return list(dict(sorted(answer.items(), key=lambda item: item[1], reverse=True)).keys())


def solution(N, stages):
    answer = defaultdict(int)
    users = len(stages)
    for stage in range(1, N+1):
        if users != 0:
            count = stages.count(stage)
            answer[stage] = count / users
            users -= count
        else:
            answer[stage] = 0
    return sorted(answer, key=lambda x: answer[x], reverse=True)


if __name__ == '__main__':
    print(solution(5, [2, 1, 2, 6, 2, 4, 3, 3]))
    print(solution(4, [4, 4, 4, 4, 4]))