def solution(numbers, hand):
    answer = ''
    L_cur = 10	#왼손 *에서 시작 (거리계산을 위해 *을 10 인덱스로 변경)
    R_cur = 12	#오른손 #에서 시작 (거리계산을 위해 #을 12 인덱스로 변경)

    for n in numbers:
        print(L_cur, R_cur)
        if n == 1 or n == 4 or n == 7:	#1,4,7을 누르는 경우는 왼손 사용
            answer += "L"
            L_cur = n	#다음 넘버까지의 거리 계산을 위해 현재 왼손으로 누른 번호 저장
        elif n == 3 or n == 6 or n == 9:	#3,6,9을 누르는 경우는 오른손 사용
            answer += "R"
            R_cur = n
        else:
            if n == 0:	#거리계산을 위해 0을 11 인덱스로 변경
                n = 11
                
            L_dis = abs(L_cur-n) // 3 + abs(L_cur-n) % 3	#step2. 거리 차이 계산
            R_dis = abs(R_cur-n) // 3 + abs(R_cur-n) % 3
            
            if L_dis > R_dis:	#왼손의 계산값이 더 크다면 오른손으로 누름
                answer += "R"
                R_cur = n
            elif R_dis > L_dis:	#오른손의 계산값이 더 크다면 왼손으로 누름
                answer += "L"
                L_cur = n
            else:	#계산값이 같은경우
                if hand == "right":	#오른손잡이는 오른손으로
                    answer += "R"
                    R_cur = n
                else:	#왼손잡이는 왼손으로
                    answer += "L"
                    L_cur = n
    return answer

