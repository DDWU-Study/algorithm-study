package com.ddwu.study.hyesun._23년03월;

//https://www.acmicpc.net/problem/11057
/*
끝자리 0 1 2 3 4 5 6 7 8 9
1자리 1 1 1 1 1 1 1 1 1 1  = 10

2자리   9 8 7 6 5 4 3 2 1 -> 10, 20자리수가능개수
2자리   1 2 3 4 5 6 7 8 9 -> 끝자리 개수

 */
//틀림
public class w27_1_오르막수_11057 {

    public static void main(String[] args) {
        int n = new java.util.Scanner(System.in).nextInt();
        

        int[][] dp = new int[n + 1][10];
        // 한자리수 모두 1로 통일
        for (int i = 0; i < 10; i++) dp[1][i] = 1;

        //2-n 번재줄(자릿수)마다 0-9끝자리수 모두 탐색
        for (int i = 2; i < (n + 1); i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i - 1][k];
                }
                dp[i][j] %= 10007;
            }

        }


        int answerCnt = 0;
        for (int i : dp[n]) answerCnt += i;

        System.out.println(answerCnt & 10007);

    }


}
