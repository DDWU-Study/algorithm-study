package com.ddwu.study.hyesun._22년11월;

//https://school.programmers.co.kr/learn/courses/30/lessons/42860?language=java
/*
    주의점
    - 좌우 이동거리가 같은경우 갈 방향
*/
public class w12_2_조이스틱 {

    static int solution(String name) {
        int answerMin = 'Z'-'A';
        char now = 'A';
        int loopMin='Z'-'A';
        for (char ch : name.toCharArray()) {
            int upNext = ch- now;
            int downPrev = ('Z'-'A'+1) - upNext;
            loopMin = Math.min(upNext, downPrev);

            //좌우 해결못함..
        }
        return answerMin;
    }
    public static void main(String[] args) {
        System.out.println(solution("JEROEN"));
        System.out.println(solution("JAN"));
    }
}
