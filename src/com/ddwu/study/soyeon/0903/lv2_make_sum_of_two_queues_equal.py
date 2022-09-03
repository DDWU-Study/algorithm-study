def solution(queue1, queue2):
    answer = -2
    total = int((sum(queue1) + sum(queue2)) / 2)

    print(queue1.pop(0))
    queue1.insert(len(queue1), 0)
    print(queue1)
    return answer


if __name__ == '__main__':
    queue1 = [3, 2, 7, 2]
    queue2 = [4, 6, 5, 1]
    print(solution(queue1, queue2))