package _23년03월;

import java.util.Arrays;
import java.util.Scanner;

//https://www.acmicpc.net/problem/1309
/*

 */
public class w26_2_동물원_1309 {
    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dp[][] = new int[n + 1][3];
        Arrays.fill(dp[1], 1);
        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2];
            dp[i][1] = dp[i - 1][0] + dp[i - 1][2];
            dp[i][2] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][0] %= 9901;
            dp[i][1] %= 9901;
            dp[i][2] %= 9901;
        }
        int sum = 0;
        for (int i = 0; i < 3; i++) sum += dp[n][i];
        System.out.println(sum % 9901);
    }
}