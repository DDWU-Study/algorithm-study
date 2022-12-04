package com.ddwu.study.hyesun._22년12월;

import java.util.Stack;

//https://school.programmers.co.kr/learn/courses/30/lessons/12973
/*
    오답수정
    30점 : 정규표현식 |연산 :

    풀이참고 : https://okky.kr/articles/389493
    다른사람 풀이 : https://school.programmers.co.kr/learn/courses/30/lessons/12973/solution_groups?language=java

 */
public class w15_3_짝지어제거하기 {
    static int solution(String s) {

/*  30점 정규표현식
        int maxTry = s.length();
        while (maxTry-- > 0) {
            s = s.replaceAll("aa|bb|cc|dd|ee|ff|gg|hh|ii|jj|kk|ll|mm|nn|oo|pp|qq|rr|ss|tt|uu|vv|ww|xx|yy|zz", "");
        }
*/
        // 스택
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if( ! stack.isEmpty() && stack.peek() == c) stack.pop();
            else
                stack.push(c);
        }

        return stack.size()==0 ? 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(solution("baabaa"));
        System.out.println(solution("cdcd"));
    }
}
