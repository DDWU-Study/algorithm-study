package com.ddwu.study.hyesun._23년03월;


import java.util.Scanner;

/*
ㅈ우복조합 : 합을 이루고 있는 수의 순서만 다른 것은 같은 것으로 친다.
이런 중복의 제거 유형은 대체로 오름차순으로 두어야 한다고 한다.

 */
public class w29_1_123더하기4_15989 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //144ms
        int dp[][] = new int[10001][4];

        dp[1][1] = 1;
        dp[1][2] = 0;
        dp[1][3] = 0;

        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[2][3] = 0;

        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 4; i < 10001; i++) {
            dp[i][1] = dp[i - 1][1];
            dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
            dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
        }

        int tc = sc.nextInt();

        String answer = "";
        while (tc-- > 0) {
            int n = sc.nextInt();
            int sum = dp[n][1] + dp[n][2] + dp[n][3];
            answer += (sum + "\n");
        }
        System.out.println(answer);
    }
}
