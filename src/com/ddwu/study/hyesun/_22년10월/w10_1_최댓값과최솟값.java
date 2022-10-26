package com.ddwu.study.hyesun._22년10월;

//https://school.programmers.co.kr/learn/courses/30/lessons/12939?language=java
/*
    초기값= Integer.MAX_VAlUE → split[0] 첫값으로 대체
 */
public class w10_1_최댓값과최솟값 {
    static String solution(String s) {
        String[] split = s.split(" ");
        int start = Integer.parseInt(split[0]);
        int max=start, min=start;
        for (String str : split) {
            int i = Integer.parseInt(str);
            if(max < i) max = i;
            if(min > i) min = i;
        }

        return min+ " "+max;
    }

    public static void main(String[] args) {
        System.out.println(solution("1 2 3 4"));
        System.out.println(solution("-1 -2 -3 -4"));
        System.out.println(solution("-1 -1"));
    }
}
