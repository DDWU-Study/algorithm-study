package com.ddwu.study.hyesun._23년02월;


//https://www.acmicpc.net/problem/11727
/*
    [0], [1] 인덱스 toggle
    XOR 연산으로 2번째 전 값을 토글
    직전값 = (i %2)^1;

*/
public class w25_1_2n타일링2_11727 {
    public static void main(String[] args) {
        int n = new java.util.Scanner(System.in).nextInt();

        //solve2 - int[2] : XOR연산으로 2번째 전 값(0,1) toggle
        int[] dp = {1, 1};
        for (int i = 2; i < (n + 1); i++) {
            int twoBack = i %2;
            int prev = twoBack ^1; // 0, 1 토글하기위해 xor연산 사용
            dp[i%2] = (dp[prev] + 2*dp[twoBack]) % 10007;
        }
        //116ms, 376B
        System.out.println(dp[n%2]);

        solveDp_1(n); // int[n+2]
    }

    static void solveDp_1(int n) {
        int[] dp = new int[n + 2];
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i < (n + 1); i++) {
            dp[i] = (dp[i-1] + 2*dp[i-2]) % 10007;
        }
        System.out.println(dp[n]);
    }

}
