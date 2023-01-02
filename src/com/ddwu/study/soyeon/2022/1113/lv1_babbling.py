def solution2(babbling):
    answer = 0
    pronunciation = ['aya', 'ye', 'woo', 'ma']
    for babl in babbling:
        for pronun in pronunciation:
            if pronun * 2 not in babl:
                # babl = babl.replace(pronun, '')   # 이 부분만 다른데 왜...?
                babl = babl.replace(pronun, ' ')
        # if babl == '':
        if babl.isspace():
            answer += 1

    return answer


def solution(babbling):
    count = 0
    babble = ["aya", "ye", "woo", "ma"]
    for utter in babbling:
        for text in babble:
            if text * 2 not in utter:
                utter = utter.replace(text, ' ')
        if utter.strip() == '':
            count += 1
    return count


if __name__ == '__main__':
    print(solution(["aya", "yee", "u", "maa"]))
    print(solution(["ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"]))
