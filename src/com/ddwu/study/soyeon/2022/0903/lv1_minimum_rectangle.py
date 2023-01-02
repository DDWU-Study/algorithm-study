def solution(sizes):
    w = []
    h = []
    for size in sizes:
        if size[0] >= size[1]:  # w > h
            w.append(size[0])
            h.append(size[1])
        else:
            w.append(size[1])
            h.append(size[0])
    return max(w) * max(h)


if __name__ == '__main__':
    sizes = [[60, 50], [30, 70], [60, 30], [80, 40]]
    print(solution(sizes))