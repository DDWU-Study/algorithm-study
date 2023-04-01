import sys
input = sys.stdin.readline

# 전형적인 시뮬레이션 문제 (블로그 발췌) -> 문제에서 요구하는 내용을 오류없이 성실하게 구현만 할 수 있으면 풀 수 있음
# 방향 설정 문제에서는 dx, dy라는 별도의 리스트를 만들어 방향을 정하는 것이 효과적임

# 0 3 2 1 순으로 돌아야 함
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

n, m = map(int, input().split())
r, c, d = map(int, input().split())     # d - 0: 북쪽, 1: 동쪽, 2: 남쪽, 3: 서쪽
graph = [list(map(int, input().split())) for _ in range(n)]
visited = [[0 for _ in range(m)] for _ in range(n)]

visited[r][c] = 1
cnt = 1

while True:
    flag = False    # 청소 안한 상태
    for _ in range(4):
        d = (d + 3) % 4  # 왼쪽 방향
        nx = r + dx[d]
        ny = c + dy[d]

        # 범위 안에 돌고 빈칸이고 청소할 수 있는 경우
        if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] == 0:
            if visited[nx][ny] == 0:
                visited[nx][ny] = 1
                cnt += 1
                r = nx
                c = ny
                flag = True  # 청소 완
                break

    if not flag:
        if graph[r - dx[d]][c - dy[d]] == 1:  # 벽인 경우
            print(cnt)
            break
        else:
            r, c = r - dx[d], c - dy[d]