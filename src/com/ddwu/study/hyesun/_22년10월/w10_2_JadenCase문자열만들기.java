package com.ddwu.study.hyesun._22년10월;

//https://school.programmers.co.kr/learn/courses/30/lessons/12951?language=java

/*
    문제조건
    -  모든 단어의 첫 문자가 대문자
    -  그 외의 알파벳은 소문자인 문자열
    - 첫 문자가 알파벳이 아닐 때에는 이어지는 알파벳은 소문자


    헷갈림
    - 문자열 양끝 공백 ▶ .trim()
    - 공백문자 연속 ▶ 런테임에러 ▶ 공백단위로 자르기❌
    - 8번만 틀림
        ▶ 문자열 마지막에 공백이 포함되어 있으면 공백도 출력 해줘야합니다

    몰랐던점
    - toUpperCase() : 숫자는 같은값으로 통과
    - .indexOf() : 안에들어가는값은 ch, str 둘 다 가능 (역추적용)

    더 알아볼것
    - string 문자열 맨 앞글자만 교체하는 함수?? ❤

 */
public class w10_2_JadenCase문자열만들기 {
    static String solution(String s) {
        String[] arr = s.toLowerCase().split("");
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        for (String str : arr) {
            if (isFirst) {
                str = str.toUpperCase();
            }
            isFirst = false;
            isFirst = str.isBlank(); //띄어쓰기 나올 때 마다 F -> T
            sb.append(str);
        }
        return sb.toString().trim();
    }

    static String solution_오답(String s) {
        String[] arr = s.toLowerCase().split(" ");
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        for (String word : arr) {
            if (s.isBlank()) continue;
            String first = word.substring(0, 1);
            if (first.matches("[a-z]")) { //.toUpperCase()가 숫자반환안하는줄..
                first = first.toUpperCase();
            }
            sb.append(first);
            sb.append(word.substring(1) + " ");
            isFirst = false;
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(solution("3people unFollowed me"));
        System.out.println(solution("for the last week"));
    }
}
