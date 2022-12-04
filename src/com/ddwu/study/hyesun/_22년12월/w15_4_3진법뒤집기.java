package com.ddwu.study.hyesun._22년12월;
//https://school.programmers.co.kr/learn/courses/30/lessons/68935
/*
모범풀이 : https://school.programmers.co.kr/learn/courses/30/lessons/68935/solution_groups?language=java
 */
public class w15_4_3진법뒤집기 {
    static int solution(int n) {
        int answer=0;
        // 10 -> 3진법 반대로뒤집음
        StringBuilder thr = new StringBuilder();
        while (n > 0) {
            thr.append(n % 3);
            n /= 3;
        }
        int max = thr.length();
        for (char c : thr.toString().toCharArray()) {
            --max;
            if(c == '0') continue;
            answer += (c-'0')  * Math.pow(3, max);
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(45));
        System.out.println(solution(125));
    }
}
