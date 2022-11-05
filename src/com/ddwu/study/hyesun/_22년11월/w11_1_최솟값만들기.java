package com.ddwu.study.hyesun._22년11월;

import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/12941
public class w11_1_최솟값만들기 {

    /*
        오름 차순 정렬 2개 + B[] 역방향 으로 접근
     */

    static int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int answer = 0;
        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[B.length - i - 1];
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 4, 2}, new int[]{5, 4, 4}));
        System.out.println(solution(new int[]{1, 2}, new int[]{3, 4}));
    }
}
