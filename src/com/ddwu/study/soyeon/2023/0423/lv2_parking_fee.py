from collections import defaultdict
import math


def subtract_time(start_time, end_time='23:59'):
    start_hour, start_minute = start_time.split(':')
    end_hour, end_minute = end_time.split(':')

    start_hour, start_minute = int(start_hour), int(start_minute)
    end_hour, end_minute = int(end_hour), int(end_minute)

    total_start_minutes = start_hour * 60 + start_minute
    total_end_minutes = end_hour * 60 + end_minute

    return total_end_minutes - total_start_minutes


def solution(fees, records):
    answer = []
    record_dict = defaultdict(list)
    for record in records:
        time, num, status = record.split()
        if status == 'IN':
            record_dict[num].append(time)
        else:   # OUT인 경우
            temp = subtract_time(record_dict[num].pop(), time)
            record_dict[num].append(temp)

    record_dict = sorted(record_dict.items(), key=lambda item: item[0])
    for i in range(len(record_dict)):
        if ':' in str(record_dict[i][1][-1]):
            result_time = subtract_time(record_dict[i][1][-1])
            del record_dict[i][1][-1]
            record_dict[i][1].append(result_time)

    result = []
    for item in record_dict:
        result.append(sum(item[1]))

    print(result)
    for r in result:
        if r > fees[0]:
            tmp = fees[1] + math.ceil((r - fees[0]) / fees[2]) * fees[3]
            answer.append(tmp)
        else:
            answer.append(fees[1])
    return answer


if __name__ == '__main__':
    print(solution([180, 5000, 10, 600], ["05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT",
                                          "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN",
                                          "23:00 5961 OUT"]))   # [14600, 34400, 5000]
    print(solution([120, 0, 60, 591], ["16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT",
                                       "23:58 3961 IN"]))   # [0, 591]
    print(solution([1, 461, 1, 10], ["00:00 1234 IN"]))     # [14841]