package com.ddwu.study.hyesun._23년04월;


import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/150368
/*
    조건
     - 비율 이상 할인하는 이모티콘을 모두 구매
     - 매 비용의 합이 일정 가격 이상이 된다면, 이모티콘 구매를 모두 취소하고 이모티콘 플러스 서비스에 가입


    users[][0] 비율이상 할인 하면 모두 산다

    모든 경우의 수 문제 - all Cases

    미완성

*/
public class w31_1_이모티콘할인행사_카카오2023 {
    static double[] discounts = {0.9, 0.8, 0.7, 0.6};

    static int[] solution(int[][] users, int[] emoticons) {
        int joiner = 0, sumRevenue = 0;

//        int[][][] table = new int[users.length][emoticons.length][4];
        int[][] discountTable = new int[emoticons.length][4];

        for (int i = 0; i < discountTable.length; i++) {
            for (int j = 0; j < 4; j++) {
                discountTable[i][j] = (int) (emoticons[i] * discounts[j]);
            }
        }

        for (int[] ints : discountTable) {
            System.out.println(Arrays.toString(ints));
        }


        //4^이모티콘개수 경우의수 bucket 중복순열 - 2차원 조합

        int[] bucket = new int[emoticons.length];
        boolean[] used = new boolean[emoticons.length];
        combineCases(bucket, new boolean[emoticons.length], 0, 0, emoticons.length);
        for (int i = 0; i < discountTable.length; i++) {
            for (int j = 0; j < 4; j++) {
                bucket[i] = discountTable[i][j];
                used[i] = true;
            }
            if (!used[i]) {
                used[i] = true;


            }
        }


        return new int[]{joiner, sumRevenue};
    }

    static void combineCases(int[] bucket, boolean[] used, int i, int j, int len) {

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[][]{{40, 10000}, {25, 10000}}, new int[]{7000, 9000})));
//        System.out.println(solution(new int[][]{{}}, new int[]{}));
    }


}
