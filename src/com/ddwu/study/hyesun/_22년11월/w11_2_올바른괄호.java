package com.ddwu.study.hyesun._22년11월;

//https://school.programmers.co.kr/learn/courses/30/lessons/12909

/*
    스택값 '('로 동일한 문자 → 개수만 세면 된다
*/

public class w11_2_올바른괄호 {
    static boolean solution(String s) {
//        Stack<Character> stack = new Stack<>();
        int cntC =0;
        for (char c : s.toCharArray()) {
            if (c == ')') {
                if (cntC ==0) return false;
                --cntC;
            }else
                ++cntC;
        }
//        return cntC>0 ? false : true;
        return cntC <= 0;
    }

    public static void main(String[] args) {
        System.out.println(solution("()()"));
        System.out.println(solution("(())()"));
        System.out.println(solution(")()("));
        System.out.println(solution("(()("));
    }
}
