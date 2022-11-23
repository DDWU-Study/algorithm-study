package com.ddwu.study.hyesun._22년11월;

//https://school.programmers.co.kr/learn/courses/30/lessons/12926
/*

    시저암호 : 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식
    "AB"는 1만큼 밀면 "BC"
    "AB"는 3만큼 밀면 "DE"
    공백은 아무리 밀어도 공백입니다.

 */
public class w14_5_시저암호 {
    static String solution(String s, int n) {
        StringBuilder sbd = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ')
                sbd.append(' ');
            else if (c < 'a')  //대문자
                sbd.append( (char)(c+n<='Z' ? c+n : 'A'+c+n-'Z'-1) );
            else
                sbd.append( (char)(c+n<='z' ? c+n : 'a'+c+n-'z'-1) );
        }
        return sbd.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("AB", 1));
        System.out.println(solution("z", 1));
        System.out.println(solution("a B z", 4));
    }
}
