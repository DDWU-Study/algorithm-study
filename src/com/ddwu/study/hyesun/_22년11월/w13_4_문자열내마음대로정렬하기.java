package com.ddwu.study.hyesun._22년11월;

import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/12945
public class w13_4_문자열내마음대로정렬하기 {
    static String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (o1, o2) -> {
            char ch1 = o1.charAt(n);
            char ch2 = o2.charAt(n);
            if (ch1 == ch2) {
                return o1.compareTo(o2);
            }
            return ch1 - ch2;
        });
        return strings;
    }

    public static void main(String args[]) throws Exception {
        System.out.println(Arrays.toString(solution(new String[]{"sun", "bed", "car"}, 1)));
        System.out.println(Arrays.toString(solution(new String[]{"abce", "abcd", "cdx"}, 2)));
    }
}
