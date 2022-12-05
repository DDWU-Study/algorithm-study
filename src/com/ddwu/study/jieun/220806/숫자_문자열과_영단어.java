package com.ddwu.study.jieun.week2;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class 숫자_문자열과_영단어 {

    public static void main(String[] args) {
        String word1 = "one4seveneight";
        System.out.println("word1 : " + solution(word1));

        String word2 = "23four5six7";
        System.out.println("word2 : " + solution(word2));

        String word3 = "2three45sixseven";
        System.out.println("word3 : " + solution(word3));

        String word4 = "123";
        System.out.println("word4 : " + solution(word4));

    }

    // 숫자의 일부 자릿수가 영단어로 바뀌어진 것들을 다시 숫자로 반환해 result 생성
    // s가 zero나 0으로 시작하는 경우는 주어지지 않음
    public static int solution(String s) {
        String[] num_list = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int num = 0; num < num_list.length; num++) {
            s = s.replace(num_list[num], String.valueOf(num));
        }
        return Integer.parseInt(s);
    }
}
