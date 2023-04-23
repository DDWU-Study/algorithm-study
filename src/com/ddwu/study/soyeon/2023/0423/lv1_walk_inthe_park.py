def solution(park, routes):
    x, y = 0, 0
    r, c = len(park), len(park[0])  # 경계 확인

    # 시작점 찾기
    for i, row in enumerate(park):
        if 'S' in row:
            x, y = i, row.find('S')
            break

    # 경로 순회
    direction = {'E': (0, 1), 'S': (1, 0), 'N': (-1, 0), 'W': (0, -1)}
    for route in routes:
        d, m = route.split(' ')
        dx, dy = direction[d]
        temp_x, temp_y = x, y
        for _ in range(int(m)):
            if 0 <= temp_x + dx < r and 0 <= temp_y + dy < c and park[temp_x + dx][temp_y + dy] != 'X':
                temp_x, temp_y = temp_x + dx, temp_y + dy
            else:
                temp_x, temp_y = x, y
                break
        x, y = temp_x, temp_y

    return [x, y]


if __name__ == '__main__':
    print(solution(["SOO", "OOO", "OOO"], ["E 2", "S 2", "W 1"]))   # [2, 1]
    print(solution(["SOO", "OXX", "OOO"], ["E 2", "S 2", "W 1"]))   # [0, 1]
    print(solution(["OSO", "OOO", "OXO", "OOO"], ["E 2", "S 3", "W 1"]))  # [0, 0]