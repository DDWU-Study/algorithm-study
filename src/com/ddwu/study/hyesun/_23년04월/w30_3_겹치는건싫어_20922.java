package com.ddwu.study.hyesun._23년04월;

import java.util.Arrays;
import java.util.Scanner;

public class w30_3_겹치는건싫어_20922 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), K = sc.nextInt();
        sc.nextLine();
        int[] num = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] cnt = new int[100001];
        int start = 0, end = 0;
        int answerlen = 0;
        while (end < N) {
            while (end < N && cnt[num[end]] + 1 <= K) {
                cnt[num[end++]]++;
            }
            int len = end - start;
            answerlen = Math.max(answerlen, len);

            cnt[num[start++]]--;
        }

        System.out.println(answerlen);
    }
}
