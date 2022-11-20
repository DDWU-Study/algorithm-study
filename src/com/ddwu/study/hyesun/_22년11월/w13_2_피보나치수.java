package com.ddwu.study.hyesun._22년11월;

//https://school.programmers.co.kr/learn/courses/30/lessons/12945
public class w13_2_피보나치수 {

    static int solution(int n) {
        int a = 0, b = 1, c = a + b;
        while (n-->0) {
            a = b;
            b = c;
            c = (a + b) % 1234567;
        }
        return a % 1234567;
    }

    public static void main(String args[]) throws Exception {
        System.out.println(solution(3));
        System.out.println(solution(5));
    }
}
