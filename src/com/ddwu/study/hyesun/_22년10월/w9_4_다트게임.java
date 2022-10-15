package com.ddwu.study.hyesun._22년10월;

import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/17682

public class w9_4_다트게임 {
    public static int solution(String dartResult) {
        char[] c = dartResult.toCharArray();
        int num = 0, indexS = -1, scores[] = {0, 0, 0};
        for (int i = 0; i < c.length; i++) {
            if (c[i] >= '0' && c[i] <= '9') {
                indexS++;
                if (c[i] == '1' && c[i + 1] == '0') {
                    num = 10;
                    ++i;

                } else {
                    num = c[i] - '0';
                }
                continue;
            } else if (c[i] == 'S' || c[i] == 'D' || c[i] == 'T') {
                num = howMuchPow(num, c[i]);
            } else if (c[i] == '*') {
                num *= 2;
                if (indexS > 0) scores[indexS-1] *=2;
            } else if (c[i] == '#') {
                num *= -1;
            }

            scores[indexS] = num;
        }

        return Arrays.stream(scores).sum();

    }

    private static int howMuchPow(int num, char powChar) {
        if (powChar == 'S') return num;
        if (powChar == 'D') return num * num;
        return num * num * num;
    }


    public static void main(String[] args) {
        System.out.println(solution("1S2D*3T"));
        System.out.println(solution("1D2S#10S"));
        System.out.println(solution("1D2S0T"));
        System.out.println(solution("1S*2T*3S"));
        System.out.println(solution("1D#2S*3S"));
        System.out.println(solution("1T2D3D#"));
        System.out.println(solution("1D2S3T*"));
    }
}
