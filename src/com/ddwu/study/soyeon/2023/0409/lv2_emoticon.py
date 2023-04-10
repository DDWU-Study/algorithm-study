from itertools import product


def solution(users, emoticons):
    answer = [0, 0]

    # 이모티콘 각각의 할인율 조합
    discounts = product([10, 20, 30, 40], repeat=len(emoticons))

    for discount in discounts:

        tmp = [0, 0]  # 이모티콘 가입자 수, 이모티콘 매출액

        for user in users:
            paid = 0
            for d, e in zip(discount, emoticons):
                if d >= user[0]:
                    paid += e * (100 - d) / 100

            if paid >= user[1]:
                tmp[0] += 1
            else:
                tmp[1] += paid

        if answer[0] < tmp[0]:
            answer[0] = tmp[0]
            answer[1] = tmp[1]
        elif answer[0] == tmp[0]:
            if answer[1] < tmp[1]:
                answer[1] = tmp[1]
    return answer