def solution(n):
    answer = 0
    nums = [_ for _ in range(1, n+1)]
    for i in range(n):
        for j in range(i+1, n+1):
            if sum(nums[i:j]) == n:
                answer += 1
                break
            elif sum(nums[i:j]) > n:
                break
    return answer


def solution2(n):
    return len([i for i in range(1, n+1, 2) if n % i == 0])


if __name__ == '__main__':
    print(solution(15))
    print(solution2(15))