package com.ddwu.study.hyesun._22년09월;
// 가로, 세로 중 가장 긴 최댓값 고정


public class w5_4_최소직사각형 {
    public static int solution(int[][] sizes) {

        for (int[] s : sizes) {
            if (s[0] >= s[1]) continue;

            s[0] = s[0] + s[1];
            s[1] = s[0] - s[1];
            s[0] = s[0] - s[1];
        }

        int row = 0, col = 0;
        for (int[] s : sizes) row = Math.max(row, s[0]);
        for (int[] s : sizes) col = Math.max(col, s[1]);

        return row * col;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}}));
        System.out.println(solution(new int[][]{{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}}));
        System.out.println(solution(new int[][]{{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}}));
    }
}
