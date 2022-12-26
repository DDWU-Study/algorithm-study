package com.ddwu.study.hyesun._22년12월;

//https://school.programmers.co.kr/learn/courses/30/lessons/12985
/*

    정답 :  몇 번째 라운드에서 만나는지 (부전승X) (정답 1-20)
    4-2-1
    7-4-2

    오답수정 : 88점 : 7,9,27,33번 : 1차이지만 서로다른팀, a>b

    더 나은 풀이
    1) 홀수면 1증가 → a = a/2 + a%2;
    2) 0라운드 ~ 두팀만날때까지 while 반복문

 */
public class w17_3_예상대진표 {
    static int solution(int n, int a, int b) {
        int round = 1;

//        while (Math.abs(a-b) >1) {
        while (Math.abs(a-b) >= 1) {
            if(a%2==1 && a+1==b) break;
            if(a%2==0 && a-1==b) break;
            ++round;
            if (a % 2 == 1) ++a; // a = a/2 + a%2;
            if (b % 2 == 1) ++b; // b = b/2 + b%2;
            a /= 2;
            b /= 2;
        }

            return round;
    }

    public static void main(String[] args) {
        System.out.println(solution(8, 4, 7)); //3

        //예외
        System.out.println(solution(8, 4, 5));//정답3 오답1
        System.out.println(solution(8, 2, 3));//정답2 오답1
        System.out.println(solution(16, 9, 12));//정답2
    }
}
