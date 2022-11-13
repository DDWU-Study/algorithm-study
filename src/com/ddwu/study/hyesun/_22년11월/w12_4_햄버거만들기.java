package com.ddwu.study.hyesun._22년11월;

import java.util.ArrayList;
import java.util.Stack;

//https://school.programmers.co.kr/learn/courses/30/lessons/133502
/*

    반드시 [1231] 세트
    stack ?

    틀렸습니다
    64.7점 : 3~6,9,12 : 정규 표현식으로 이렇게 하나씩 찾아서 지우면 시간초과
    3~12번 : https://school.programmers.co.kr/questions/39130

    모범
    스택 고정배열 int[]  : https://blog.naver.com/whhwhh/222913079679
*/
public class w12_4_햄버거만들기 {

    static int solution(int[] ingredient) {
        int answerBurger = 0;

//        answerBurger = loopRegex(ingredient, answerBurger);
//        answerBurger = stackBurger(ingredient, answerBurger);
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < ingredient.length; i++) {
            int n = ingredient[i];
            if (al.size() >= 3 && n == 1) {
                int lastIndex = al.size()-1;
                if (al.get(lastIndex-2) == 1 && al.get(lastIndex-1) == 2 && al.get(lastIndex) == 3) {
                    ++answerBurger;
                    al.remove(al.size() - 1);
                    al.remove(al.size() - 1);
                    al.remove(al.size() - 1);
                    continue;
                }
            }
            al.add(n);
        }

        return answerBurger;
    }

    private static int stackBurger(int[] ingredient, int answerBurger) {
        Stack<Integer> stack = new Stack<>();
        for (int i : ingredient) {
            if (stack.size() >= 3 && i == 1) {
                if (stack.peek() == 3) {
                    Integer pop3 = stack.pop();
                    if (stack.peek() == 2) {
                        Integer pop2 = stack.pop();
                        if (stack.peek() == 1) {
                            stack.pop();
                            ++answerBurger;
                            continue;
                        }
                        stack.push(pop2);
                    }
                    stack.push(pop3);
                }
            } else stack.push(i);
        }
        return answerBurger;
    }

    private static int loopRegex(int[] ingredient, int answer) {
        // int[] → String
        StringBuilder sb = new StringBuilder();
        for (int i : ingredient) sb.append(i);
        String str = sb.toString();

        while (str.contains("1231")) {
            String replacedStr = str.replaceFirst("1231", "");
            int len = str.length();
            int burger = (len - replacedStr.length()) / 4;
            answer += burger;
            str = replacedStr;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1})); //2
        System.out.println(solution(new int[]{1, 3, 2, 1, 2, 1, 3, 1, 2})); //0

        System.out.println(solution(new int[]{1, 1, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1})); //정답3 내오답2

        System.out.println(solution(new int[]{1, 1, 2, 1, 2, 3, 1, 3, 1, 2, 3, 1})); //정답3
        System.out.println(solution(new int[]{1, 1, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1})); //정답3
        System.out.println(solution(new int[]{1, 2, 3, 1, 2, 3, 1, 1, 1, 1, 2, 3, 1, 2, 3, 1, 1, 1, 1, 1, 1, 2, 3, 3, 1, 2, 3, 1, 3, 3, 3, 2, 1, 2, 3, 1})); //정답 5
        System.out.println(solution(new int[]{1, 2, 3, 1, 2, 3, 1, 1, 1, 1, 2, 3, 1, 2, 3, 1, 1, 1, 1, 1, 1, 2, 3, 3, 1})); //정답3
        System.out.println(solution(new int[]{1, 2, 3, 1, 2, 3, 1, 1, 1, 1, 2, 3, 1, 2, 3, 1})); //정답3
        System.out.println(solution(new int[]{1, 2, 2, 3, 1})); //정답 0
    }
}
