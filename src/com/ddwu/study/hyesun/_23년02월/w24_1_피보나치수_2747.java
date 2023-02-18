package com.ddwu.study.hyesun._23년02월;


//https://www.acmicpc.net/problem/2747
/*
    백준 피보나치 1-7  : 2747, 2748, 2749, 10826, 10870, 11444, 15624
    백준 피보나치 시리즈 : https://www.acmicpc.net/workbook/view/1936
*/
public class w24_1_피보나치수_2747 { //0부터시작하는 fibo
    public static void main(String[] args) {
        long n = new java.util.Scanner(System.in).nextLong();

        //108ms
        long[] dp = {0, 1};
        for (int i = 2; i < n+1; i++) {
            dp[i % 2] = dp[0] + dp[1];
        }
//        System.out.println(dp[n%2]);
        System.out.println(dp[(int) (n%2)]); //2 - long
    }
}
