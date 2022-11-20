def solution(strings, n):
    return sorted(sorted(strings), key=lambda x: x[n])


if __name__ == '__main__':
    print(solution(["sun", "bed", "car"], 1))
    print(solution(["abce", "abcd", "cdx"], 2))