package com.ddwu.study.hyesun._23년02월;

import java.util.Scanner;

//https://www.acmicpc.net/problem/2579      `
/*

    조건
    X : 연속된 3개계단
    X : 시작점 / O : 마지막계단은 반드시 포함

 */
public class w23_1_계단오르기_2579 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int[] score = new int[n +1];
        int[] dp = new int[n +1];
        for(int i=0; ++i<n + 1; score[i]=sc.nextInt());

        if(n==1 || n == 2) {
            System.out.println(n==1 ? score[1] : score[1] + score[2]);
            return;
        }

        dp[1] = score[1];
        dp[2] = score[1] + score[2];
        for(int i=3; i<(n + 1); i++){
            dp[i] = Math.max(dp[i-2], score[i-1] + dp[i-3]);
            dp[i] += score[i];
        }
        System.out.println(dp[n]);
    }
}