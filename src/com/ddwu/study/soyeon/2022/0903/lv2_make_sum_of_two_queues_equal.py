from collections import deque


def solution(queue1, queue2):
    queue1, queue2 = deque(queue1), deque(queue2)
    total = int((sum(queue1) + sum(queue2)) / 2)    # 원래 내가 하고 싶었던 방법
    queue1_sum = sum(queue1)
    answer = 0
    while queue1 and queue2:
        if queue1_sum == total:
            return answer
        elif queue1_sum > total:
            queue1_sum -= queue1[0]
            queue2.append(queue1.popleft())
        else:
            queue1_sum += queue2[0]
            queue1.append(queue2.popleft())
        answer += 1
    return answer


if __name__ == '__main__':
    queue1 = [3, 2, 7, 2]
    queue2 = [4, 6, 5, 1]
    print(solution(queue1, queue2))