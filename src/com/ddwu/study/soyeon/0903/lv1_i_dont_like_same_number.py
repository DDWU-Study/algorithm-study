def solution(arr):
    answer = [arr[0]]
    for i in range(1, len(arr)):
        if arr[i] != arr[i - 1]:
            answer.append(arr[i])
    return answer


if __name__ == '__main__':
    arr = [4,4,4,3,3]
    print(solution(arr))