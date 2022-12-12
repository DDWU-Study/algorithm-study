package com.ddwu.study.hyesun._22년12월;

import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/42885
/*

    Two Pointer

    정답 : 구명보트 개수의 최솟값을 return

    오답교정
    30점
    70점 : 4,5,7,10,13, 효3 : i <= end 로 등호추가

 */
public class w16_2_구명보트 {

    static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        int end = people.length - 1;
        for (int i = 0; i <= end; i++) { //

            while (i < end && people[i] + people[end] > limit) { //등호들어가면 틀림
                ++answer;
                --end;
            }
            ++answer;
            --end;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{70, 50, 80, 50}, 100));
        System.out.println(solution(new int[]{70, 80, 50}, 100));
    }
}
