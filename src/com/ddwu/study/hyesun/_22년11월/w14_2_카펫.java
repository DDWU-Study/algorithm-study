package com.ddwu.study.hyesun._22년11월;

import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/42842?language=java
public class w14_2_카펫 {
    static int[] solution(int brown, int yellow) {
        int sum = brown + yellow;
        for (int i = 3; i*i < sum +1; i++) {
            if(sum % i >0) continue;
            
            //약수 Divisor
            int row = sum / i;
            int outerCnt = row+row+i+i -4;
            int innerCnt = sum - outerCnt;
            if (outerCnt == brown && innerCnt == yellow) {
                return new int[]{row, i};
            }
        }
        return null;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(10,2)));
        System.out.println(Arrays.toString(solution(8,1)));
        System.out.println(Arrays.toString(solution(24,24)));
    }
}
