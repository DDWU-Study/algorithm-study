package com.ddwu.study.hyesun._23년04월;

import java.util.Arrays;
import java.util.Scanner;

/*
    i번째 수부터 j번째 수까지의 합 A[i] + A[i+1] + … + A[j-1] + A[j]가 M이 되는 경우의 수
    경우의 수  : cases(가능한 모든 경우의 수), ways(선택할 수 있는 방법이나 해결 방법의 수)\

*/
public class w31_2_수들의합2_2003 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        sc.nextLine();
        int[] num = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int iStart=0, iEnd=-1, answerCases=0;
        int sum =0;
        while (++iEnd < N) {
            //1. ++iEnd 후에 Ennd연산먼저
            sum += num[iEnd];

            //2. while iStart++ 연산
            while (sum > M) {
                sum -= num[iStart++];
            }
            //3. 조건판단
            if(sum == M) answerCases++;

            //4. 초기값0,막줄++ OR 초기값 -1 한번에/첫줄++
        }


        System.out.println(answerCases);
    }
}
