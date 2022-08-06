def get_distance(hand_num, next_num):
    keypad = {1: [0, 0], 2: [1, 0], 3: [2, 0],
              4: [0, 1], 5: [1, 1], 6: [2, 1],
              7: [0, 2], 8: [1, 2], 9: [2, 2],
              "*": [0, 3], 0: [1, 3], "#": [2, 3], }

    x1, y1 = keypad[hand_num]
    x2, y2 = keypad[next_num]

    return abs(x1-x2) + abs(y1-y2)


def solution(numbers, hand):
    answer = ''
    left_loc = "*"
    right_loc = "#"

    for number in numbers:
        if number == 1 or number == 4 or number == 7:
            answer += "L"
            left_loc = number
        elif number == 3 or number == 6 or number == 9:
            answer += "R"
            right_loc = number
        elif number == 2 or number == 5 or number == 8 or number == 0:
            left_dx = get_distance(left_loc, number)
            right_dx = get_distance(right_loc, number)

            if left_dx < right_dx:
                answer += "L"
                left_loc = number
            elif right_dx < left_dx:
                answer += "R"
                right_loc = number
            else:
                if hand == "left":
                    answer += "L"
                    left_loc = number
                else:
                    answer += "R"
                    right_loc = number

    return answer


if __name__ == '__main__':
    numbers = [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]
    hand = 'right'
    print(solution(numbers, hand))