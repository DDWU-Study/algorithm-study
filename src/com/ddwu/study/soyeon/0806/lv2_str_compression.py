def solution(s):
    s = input()
    answer = len(s)

    # 1개 단위(step)부터 압축 단위를 늘려가며 확인
    for step in range(1, len(s) // 2 + 1):
        compressed = ""
        prev = s[0:step]  # 앞에서부터 step만큼의 문자열 추출
        count = 1
        print(step,'단위로 자르는 경우')
        # 단위(step) 크기만큼 증가시키며 이전 문자열과 비교
        for j in range(step, len(s), step):
            print('j=', j)
            # 이전 상태와 동일하다면 압축 횟수(count) 증가
            print('prev=', prev)
            print('next=', s[j:j+step])
            if prev == s[j:j + step]:
                count += 1
                print('이전 상태와 동일하므로 압축횟수 증가 count=', count)
            # 다른 문자열이 나왔다면
            else:
                compressed += str(count) + prev if count >= 2 else prev
                prev = s[j:j + step]  # 다시 초기화
                count = 1
                print('다른 문자열이 나왔으므로 compressed=', compressed,'담고 prev 초기화 prev =',prev)
        # 남아 있는 문자열에 대해서 처리
        compressed += str(count) + prev if count >= 2 else prev
        print('이번 step 결과 compressed=', compressed)
        # 만들어지는 문자열이 가장 짧은 것이 정답
        print('현재 answer=', answer, '이번 step 결과 len(compressed)=', len(compressed))
        answer = min(answer, len(compressed))
        print('더 작은 값이 answer =', answer,'\n\n')

    print(answer)


if __name__ == '__main__':
    s = "aabbaccc"