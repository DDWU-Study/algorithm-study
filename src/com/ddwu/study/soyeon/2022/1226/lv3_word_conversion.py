from collections import deque


def solution(begin, target, words):
    if target not in words:  # words 리스트에 target이 없으면 바로 0 반환
        return 0

    q = deque()
    q.append([begin, 0])    # 처음 큐에 시작단어와 깊이 넣어주기

    while q:
        word, cnt = q.popleft()

        if word == target:
            return cnt  # target이 값이 되면 cnt return

        for i in range(len(words)):
            diff = 0
            for j in range(len(word)):
                if word[j] != words[i][j]:
                    diff += 1
            if diff == 1:   # 단어가 1글자만 다를 때 큐에 넣어주기
                q.append([words[i], cnt + 1])
    return 0


if __name__ == "__main__":
    print(solution("hit", "cog", ["hot", "dot", "dog", "lot", "log", "cog"]))
    print(solution("hit", "cog", ["hot", "dot", "dog", "lot", "log"]))