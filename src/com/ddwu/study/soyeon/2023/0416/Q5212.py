r, c = map(int, input().split())

dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

sea_map = [list(input()) for _ in range(r)]
next_map = [['.' for _ in range(c)] for _ in range(r)]

for i in range(r):
    for j in range(c):
        if sea_map[i][j] == 'X':
            sea = 0
            for d in range(4):  # 인접한 부분들 확인ㄴㄴㄴㄴ
                nr = i + dr[d]
                nc = j + dc[d]

                if nr < 0 or nr >= r or nc < 0 or nc >= c or sea_map[nr][nc] == '.':
                    sea += 1

            if sea >= 3:
                next_map[i][j] = '.'
            else:
                next_map[i][j] = 'X'
        else:
            next_map[i][j] = '.'

min_r, max_r = r, 0
min_c, max_c = c, 0

for i in range(r):
    for j in range(c):
        if next_map[i][j] == 'X':
            min_r = min(min_r, i)
            max_r = max(max_r, i)

            min_c = min(min_c, j)
            max_c = max(max_c, j)  # max_c를 넣었어야 했는데 min_c를 넣어서 한참 헤맴
            # print(i, j, min_r, max_r, min_c, max_c)


next_map = [row[min_c:max_c + 1] for row in next_map[min_r:max_r + 1]]
for i in range(len(next_map)):
    for j in range(len(next_map[i])):
        print(next_map[i][j], end='')
    print()