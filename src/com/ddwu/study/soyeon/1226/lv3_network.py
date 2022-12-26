def solution(n, computers):
    def dfs(node):  # dfs 수행하는 dfs 함수 정의
        visited[node] = True

        for nei in range(n):
            if not visited[nei] and computers[node][nei]:
                dfs(nei)

    count = 0
    visited = [False] * n

    for idx in range(n):  # 0번째부터 직/간접적으로 연결된 모든 컴퓨터 반복
        if not visited[idx]:  # 모든 컴퓨터를 방문할 때까지 dfs 반복
            dfs(idx)
            count += 1
    return count


if __name__ == '__main__':
    print(solution(3, [[1, 1, 0], [1, 1, 0], [0, 0, 1]]))  # 2
    print(solution(3, [[1, 1, 0], [1, 1, 1], [0, 1, 1]]))  # 1