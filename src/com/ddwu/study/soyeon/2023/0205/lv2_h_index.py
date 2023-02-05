# https://www.ibric.org/myboard/read.php?Board=news&id=270333
# 많이 인요된 순으로 정렬한 후, 피인용수가 논문수와 같거나 작아지기 시작하는 숫자가 바로 h
def solution(citations):
    citations.sort(reverse=True)
    for idx, citation in enumerate(citations):
        if idx >= citation:
            return idx
    return len(citations)