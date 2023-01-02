def solution(record):
    answer = []

    user_status = {'Enter': '님이 들어왔습니다.', 'Leave': '님이 나갔습니다.'}
    user_info = {}
    for r in record:
        rec = r.split()
        if len(rec) > 2:
            user_info[rec[1]] = rec[2]

    for r in record:
        rec = r.split()
        if rec[0] in user_status.keys():
            answer.append(user_info[rec[1]] + user_status[rec[0]])

    return answer


if __name__ == '__main__':
    record = ["Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"]
    print(solution(record))