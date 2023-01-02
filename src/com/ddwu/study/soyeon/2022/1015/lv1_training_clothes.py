def solution(n, lost, reserve):
    # 여벌 체육복을 가져온 학생(reserve)도 도난(lost)을 당할 수 있음 주의할 것
    _reserve = set(reserve) - set(lost)
    _lost = set(lost) - set(reserve)

    for i in _reserve:
        if i - 1 in _lost:  # 빌려줄 수 있는건 앞이나 뒷번호
            _lost.remove(i - 1)
        elif i + 1 in _lost:
            _lost.remove(i + 1)

    return n - len(_lost)


if __name__ == '__main__':
    print(solution(5, [2, 4], [1, 3, 5]))
    print(solution(5, [2, 4], [3]))
    print(solution(3, [3], [1]))