package com.ddwu.study.hyesun._23년02월;


//https://www.acmicpc.net/problem/11726
public class w25_2_2n타일링_11726 {
    public static void main(String[] args) {
        int n = new java.util.Scanner(System.in).nextInt();

        //112ms
        solveDp_1(n); // 크기 int[n + 2]; 배열생성
        solveDp_2(n); // 크기 [0],[1] 2개
    }

    private static void solveDp_1(int n) {
        int[] dp = new int[n + 2];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < (n + 1); i++) {
//            dp[i] = dp[i - 1] + 2 * dp[i - 2];
//            if (i % 2 == 0) num +=  dp[i - 2];
            int num = dp[i - 1] + dp[i - 2];

            dp[i] = num % 10007;
        }
        System.out.println(dp[n]);
    }
    private static void solveDp_2(int n) {
        int[] dp = {1,1};
        for (int i = 2; i < (n + 1); i++) {
            dp[i%2] = (dp[0] + dp[1]) % 10007;
        }
        System.out.println(dp[n %2]);
    }

}
