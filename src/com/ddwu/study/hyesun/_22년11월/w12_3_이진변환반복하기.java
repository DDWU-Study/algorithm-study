package com.ddwu.study.hyesun._22년11월;

import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/70129?language=java
/*

    이진수 자동변환 함수  : Integer.toBinaryString( 자연수 )

    문자종류 2가지 → 1개 없애기 → s.replaceAll("0", "")
*/
public class w12_3_이진변환반복하기 {

    static int[] solution(String s) {
        int cntRemoved0=0, round=0;
       while ( ! "1".equals(s)) {
            ++round;

            //0개 개수
            int cnt1=0, cnt0=0;
            for (char c : s.toCharArray()) {
                if(c=='1') ++cnt1;
                else ++cnt0;
            }
            cntRemoved0 += cnt0;
            // cnt1값 이진수 변환
            StringBuilder sbd = new StringBuilder();
            int n=cnt1;
            while (n > 0) {
                sbd.append(n%2);
                n /= 2;
            }
            // s 재할당
            s = sbd.toString();
        }
        return new int[]{round, cntRemoved0};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("110010101001")));
        System.out.println(Arrays.toString(solution("01110")));
        System.out.println(Arrays.toString(solution("1111111")));
    }
}
