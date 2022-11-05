package com.ddwu.study.hyesun._22년11월;

//https://school.programmers.co.kr/learn/courses/30/lessons/12921
public class w11_4_소수찾기 {
    static int solution(int n) {

        int answer = 1;
        for (int num = 2; num < n + 1; num++) {
            answer += isPrime(num) ? 1 : 0;
        }
        return answer;
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i * i < num + 1; i++) {
            if(num % i ==0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("5= " + solution(5));
        System.out.println("10= " + solution(10));
    }
}
