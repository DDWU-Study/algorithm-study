package com.ddwu.study.hyesun._23년04월;


import java.util.Arrays;
import java.util.Scanner;

//https://www.acmicpc.net/problem/13458
/*
    총감독관 (1-B명), 부감독감(1-C)명
    총은 반드시 1명 부는 0명부터
    총 < 부 : 총 1명만깔고, ([]-b)/C 명이상 배치
*/
public class w31_3_시험감독_13458 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] examinee = new int[N];
        for (int i = 0; i < examinee.length; i++) examinee[i] = sc.nextInt();
        int B = sc.nextInt(), C = sc.nextInt();


        int ansMinSupervisor = N;
        for (int i = 0; i < examinee.length; i++) {
            examinee[i] -= B;
        }

        for (int i = 0; i < N; i++) {
            if (examinee[i] > B) {
                ansMinSupervisor += examinee[i] / C;
                if(examinee[i] % C >0)
                    ansMinSupervisor++;
            }
        }

        System.out.println(Arrays.toString(examinee));

        System.out.println(ansMinSupervisor);
    }


}
