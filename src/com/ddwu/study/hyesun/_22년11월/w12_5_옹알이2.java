package com.ddwu.study.hyesun._22년11월;

//https://school.programmers.co.kr/learn/courses/30/lessons/133499
/*

    정답 : 발음할 수 있는 단어의 개수를 return (연속발음 제외)

    실패
    55점 : 1,9-11,14,16,17,19,20  : 정규표현식 대신 indexOf() + 단어길이
    65점 : 8, 11-14, 17-18 : 반복단어제거 replaceAll로 안되서 contains로 제거함


    접근방법
    w.equals(s.substring(nextIndex, nextIndex + w.length()))

    공부할점
    (1) 정규표현식 [|], 단독| 차이점

    (2) .replace()함수 3가지
        .replace(문자열)
        .replaceFirst(정규표현식)
        .replaceAll
        https://codechacha.com/ko/java-replace-vs-replaceall/


    (3) 정규표현식 함수 2가지
    .contains() : contains()는 단순히 인자로 전달된 문자열이 존재여부
    .matches() : 정규표현식을 인자, 동일한 패턴의 문자열이라면 true && 찾는 문자의 주위의 문자들도 고려
        https://hianna.tistory.com/539

    정규표현식 메소드 : https://bldev2473.github.io/java/java-regex-2/

    해설
       https://school.programmers.co.kr/learn/courses/30/lessons/133499/solution_groups?language=java

    배운점
      필터단어가 고정으로 주어지면 직접 입력
      필터단어가 동적으로 주어지면...
*/


public class w12_5_옹알이2 {
    static String[] word = {"aya", "ye", "woo", "ma"};
//    static String[] failRepeat = {"ayaaya", "yeye", "woowoo", "mama"};

    static int solution(String[] babbling) {
        int answer = 0;
        loop:
        for (String s : babbling) {
//            if (s.matches("ayaaya|yeye|woowoo|mama")) continue;
            for (String failWord : new String[]{"ayaaya", "yeye", "woowoo", "mama"}) {
                if( s.contains(failWord) ) continue loop;
            }

            s = s.replaceAll("aya|ye|woo|ma", "");
            if (s.length() == 0)
                ++answer;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"aya", "yee", "u", "maa"}));//1
        System.out.println(solution(new String[]{"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"}));//2
//
        System.out.println(solution(new String[]{"wooyemawooye"})); //1
    }
}