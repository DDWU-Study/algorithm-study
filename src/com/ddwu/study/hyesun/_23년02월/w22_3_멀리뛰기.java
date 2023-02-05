package com.ddwu.study.hyesun._23년02월;

import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/12914
/*

    25점 시간초과 - %(//) 1234567 안함
    37.5점 - 시간초과 -> 메모지에이션, dp사용

    1, 2, 3, 5
 */
public class w22_3_멀리뛰기 {
    static long solution(int n) {
//        long answer = recurse(n, 0);
//        long answer = recurseMemo(n, 0, new long[n+1]);
        long answer = dp(n);

        return answer;
    }
    private static long recurse(int n, int i) {
        if(i > n) return 0;
        if(i == n) return 1;


        long retCount=0;
        retCount += recurse(n, i+2);
        retCount += recurse(n, i+1);
        return retCount  % 1234567;
    }

    private static long dp(int n) {
        long[] dp = new long[n + 2]; // 2까지 base case   
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < (n + 1); i++) {
    //            dp[i] = dp[i-1] + dp[i-2] + 3;
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    private static long recurseMemo(int n, int i, long[] m) {
        if(i > n) return 0;
        if(m[i] >0) return m[i];
        if(i == n) return m[i] = 1;


        long retCount=0;
        retCount += recurseMemo(n, i+2, m);
        retCount += recurseMemo(n, i+1, m);
        return m[i] = retCount  % 1234567;
    }

    public static void main(String[] args) {
        System.out.println(solution(4));
        System.out.println(solution(3));
    }
}
