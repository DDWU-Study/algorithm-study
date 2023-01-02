def solution(board, moves):
    answer = 0
    stack = []

    for move in moves:
        for line in board:
            if line[move - 1] != 0:  # exclude 0인 경우
                stack.append(line[move - 1])
                line[move - 1] = 0
                break

        if len(stack) > 1 and stack[-1] == stack[-2]:
            answer += 2
            stack.pop()
            stack.pop()

    return answer


if __name__ == '__main__':
    board = [[0, 0, 0, 0, 0],
             [0, 0, 1, 0, 3],
             [0, 2, 5, 0, 1],
             [4, 2, 4, 4, 2],
             [3, 5, 1, 3, 1]]
    moves = [1, 5, 3, 5, 1, 2, 1, 4]
    print(solution(board, moves))