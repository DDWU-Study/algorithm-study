def solution(record):
    answer = []
    
    str1="님이 들어왔습니다."
    str2="님이 나갔습니다."

    id_nick_dic = {}

    for i in range(len(record)):
        sl = record[i].split()

        if sl[0] == "Enter":
            id_nick_dic[sl[1]] = sl[2]
        elif sl[0] == "Change":
            id_nick_dic[sl[1]] = sl[2]


    for i in range(len(record)):
        sl = record[i].split()
        if sl[0] == "Enter":
            answer.insert(i, id_nick_dic.get(sl[1]) + str1)
        elif sl[0] == "Leave":        
            answer.insert(i, id_nick_dic.get(sl[1]) + str2)
    
    return answer
