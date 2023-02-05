package com.ddwu.study.hyesun._23년02월;

import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/42747
/*
   문제이해가 어려움
 */
public class w22_4_HIndex {
    static int solution(int[] citations) {
        Arrays.sort(citations); //정렬

        int h;
        for (int i = 0; i < citations.length; i++) {
            h = citations.length - i;

            if (citations[i] >= h) {
                return h;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 0, 6, 1, 5}));
    }
}
