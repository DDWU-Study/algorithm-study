package com.ddwu.study.hyesun._22년12월;

import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/12982
/*

 */
public class w15_5_예산 {
    static int solution(int[] d, int budget) {
        return twoPointer(d, budget);
    }
    static int twoPointer(int[] d, int budget) {
        Arrays.sort(d); //내림차순 정렬
        int i = 0;
//        while(budget > 0 && i < d.length) {
        while(i < d.length) {
            budget -= d[i++];
            if(budget <0) return i-1;
        }
        return i;
    }
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,3,2,5,4}, 9));
        System.out.println(solution(new int[]{2,2,3,3}, 3));
    }
}
