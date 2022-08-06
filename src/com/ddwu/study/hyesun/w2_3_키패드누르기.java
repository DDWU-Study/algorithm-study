package com.ddwu.study.hyesun;
/*
 별표의 위치를 잘못해서 3,7, 16, 18만 틀림
 https://school.programmers.co.kr/questions/20616
 */

public class w2_3_키패드누르기 {
    //거리계산을 위해 2차원배열로 위치설정
    static int[][] phone = {{3, 1}
            , {0, 0}, {0, 1}, {0, 2}
            , {1, 0}, {1, 1}, {1, 2}
            , {2, 0}, {2, 1}, {2, 2}
    };

    private static char calc(int n, int[] posL, int[] posR, String hand) {
        int row=phone[n][0], col=phone[n][1];
        int distL = Math.abs(row - posL[0]) + Math.abs(col - posL[1]);
        int distR = Math.abs(row - posR[0]) + Math.abs(col - posR[1]);
        if (distR == distL) {
            if(hand.equals("right")) return 'R';
            if(hand.equals("left")) return 'L';
        }
        return (distR < distL) ? 'R' : 'L';
    }
    public static String solution(int[] numbers, String hand) {
        String answer = "";
//        int[] posL = {0, 3}, posR = {3, 2};
        int[] posL = {3,0}, posR = {3, 2}; //*, #은  초기값 위치
        char pos; //위치값 char
        for (int n : numbers) {
            //숫자로 이동할 손위치 파악
            if (n == 1 || n == 4 || n == 7)
                pos = 'L';
            else if (n == 3 || n == 6 || n == 9)
                pos = 'R';
            else
                pos = calc(n, posL, posR, hand);

            //위치가 나타나면 반환값과 손이동
            if (pos == 'L') {
                answer += "L";
                posL = phone[n];
            } else {
                answer += "R";
                posR = phone[n];
            }
        }
        return answer.toUpperCase();
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
        System.out.println(solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"));
        System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right"));
    }
}
