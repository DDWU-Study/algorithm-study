def solution(A, B):
    answer = 0

    A = sorted(A)
    B = sorted(B, reverse=True)

    for i in range(len(A)):
        answer += A[i] * B[i]

    return answer
    # return sum(a*b for a, b in zip(sorted(A), sorted(B, reverse = True)))


if __name__ == '__main__':
    print(solution([1, 4, 2], [5, 4, 4]))
    print(solution([1, 2], [3, 4]))