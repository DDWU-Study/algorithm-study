package com.ddwu.study.hyesun._22년11월;

import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/17681
/*
    자릿수 맞추기 위해 앞 0 추가 → replace
 */
public class w14_4_비밀지도 {
    static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            
            answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);

            if (answer[i].length() < n) {
                int cnt = n-answer[i].length();
                String tmp = "";
                while (cnt-->0) tmp += "0";
                tmp += answer[i];
                answer[i] = tmp;
            }

            answer[i] = answer[i].replaceAll("1", "#");
            answer[i] = answer[i].replaceAll("0", " ");

        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28})));
        System.out.println(Arrays.toString(solution(6, new int[]{46, 33, 33, 22, 31, 50}, new int[]{27, 56, 19, 14, 14, 10})));
    }
}
