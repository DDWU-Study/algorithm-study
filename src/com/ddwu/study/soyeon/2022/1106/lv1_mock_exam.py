from collections import defaultdict


def solution(answers):
    pat1 = [1, 2, 3, 4, 5]
    pat2 = [2, 1, 2, 3, 2, 4, 2, 5]
    pat3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    score = [0, 0, 0]
    answer = []

    for idx, ans in enumerate(answers):
        if ans == pat1[idx % len(pat1)]:
            score[0] += 1
        if ans == pat2[idx % len(pat2)]:
            score[1] += 1
        if ans == pat3[idx % len(pat3)]:
            score[2] += 1

    for idx, s in enumerate(score):
        if s == max(score):
            answer.append(idx + 1)

    return answer


def solution2(answers):
    score = defaultdict(int)
    pat1 = [1, 2, 3, 4, 5] * ((len(answers) // 5) + 1)
    pat2 = [2, 1, 2, 3, 2, 4, 2, 5] * ((len(answers) // 8) + 1)
    pat3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5] * ((len(answers) // 10) + 1)

    for idx, ans in enumerate(answers):
        if pat1[idx] == ans:
            score[1] += 1
        if pat2[idx] == ans:
            score[2] += 1
        if pat3[idx] == ans:
            score[3] += 1

    score = list(dict(sorted(score.items(), key=lambda item: score[1], reverse=True)).keys())
    return sorted(score)


if __name__ == '__main__':
    print(solution([1, 2, 3, 4, 5]))
    print(solution([1, 3, 2, 4, 2]))