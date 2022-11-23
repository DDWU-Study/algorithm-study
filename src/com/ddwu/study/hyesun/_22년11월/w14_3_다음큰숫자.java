package com.ddwu.study.hyesun._22년11월;

//https://school.programmers.co.kr/learn/courses/30/lessons/12911?language=java
/*
    오답 수정
    70점 : .replaceAll("0", "").length() : 효율성 모두 시간 초과
 */
public class w14_3_다음큰숫자 {
    static int solution(int n) {
        int cnt1=0;
        for (char c : Integer.toBinaryString(n).toCharArray())
            cnt1 += c - '0';

        while (n++ <= 1000000) {
            int cnt=0;
            for (char c : Integer.toBinaryString(n).toCharArray())
                cnt += c - '0';
            if(cnt == cnt1)
                return n;
        }
        return 0;
    }
    public static void main(String[] args) {
        System.out.println(solution(78));
        System.out.println(solution(15)); //15(1111)의 다음 큰 숫자는 23(10111)입니다.
    }
}
