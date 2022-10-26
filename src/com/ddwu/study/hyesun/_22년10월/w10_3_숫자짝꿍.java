package com.ddwu.study.hyesun._22년10월;

//https://school.programmers.co.kr/learn/courses/30/lessons/131128
/*
    오답수정
    1) if  -> while (중복숫자)
    2) 00 -> 0 : if(i==0 &&answer.length()==0) return "0";
    3) 73.7점 11-15번 시간초과  : 문자열 누적합(+=) 대신 StringBuilder(sbd)사용

 */
public class w10_3_숫자짝꿍 {
    static String solution(String X, String Y) {
        String answer = "";
        //작은길이 기준으로 짝궁찾아서 new int[10]채우기
        int matchCnt=0;
        int digitX[] = new int[10]; //{0,1 ... 8,9}
        int digitY[] = new int[10]; //{0,1 ... 8,9}

        for (int i = 0; i < X.length(); i++) digitX[ X.charAt(i) - '0' ]++;
        for (int i = 0; i < Y.length(); i++) digitY[ Y.charAt(i) - '0' ]++;

        StringBuilder sb = new StringBuilder();

        // 9부터 가창 큰 짝꿍만들기
        for (int i = 9; i > -1; i--) {
            while (digitX[i] > 0 && digitY[i] > 0) {
                if(i==0 &&sb.length()==0) return "0";
                sb.append(i);
                --digitX[i];
                --digitY[i];
            }
        }
        return sb.length()==0 ? "-1" : sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(solution("100","2345" ));
        System.out.println(solution("100", "203045"));
        System.out.println(solution("100", "123450"));
        System.out.println(solution("12321", "42531"));
        System.out.println(solution("5525", "1255"));
    }
}
