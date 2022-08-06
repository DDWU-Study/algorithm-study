def solution(s):
    units = {'zero': 0,
             'one': 1,
             'two': 2,
             'three': 3,
             'four': 4,
             'five': 5,
             'six': 6,
             'seven': 7,
             'eight': 8,
             'nine': 9}
    answer = ''
    # for key in units.keys():
    #    if key in s or str(units[key]) in s:
    #        answer += str(units[key])
    for key, value in units.items():
        s = s.replace(key, str(value))
    return int(s)


if __name__ == '__main__':
    print(solution("one4seveneight"))