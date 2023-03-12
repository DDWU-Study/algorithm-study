package com.ddwu.study.hyesun._23년03월;

//https://www.acmicpc.net/problem/1463
public class w27_2_일로만들기_1463 {
    public static void main(String[] args) {
        int n=new java.util.Scanner(System.in).nextInt();

        int dp[] = new int[n +3];
        dp[1] = 0;
        dp[2] = dp[3] = 1;

        for(int i=4; i<(n + 1); i++){
            int cnt = dp[i-1];
            if(i%2==0)
                cnt = Math.min(cnt, dp[i/2]);
            if(i%3==0)
                cnt = Math.min(cnt, dp[i/3]);
            dp[i] = 1 + cnt;
        }

        System.out.println(dp[n]);
    }

}
