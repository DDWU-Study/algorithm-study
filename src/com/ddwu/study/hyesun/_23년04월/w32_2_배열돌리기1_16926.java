package com.ddwu.study.hyesun._23년04월;

import java.util.Scanner;

//https://www.acmicpc.net/problem/16926
/*
    왼쪽 90도 = 오른쪽 270도 회전
    - 안쪽으로 들어올 때마다 너비와 높이가 2씩 줄어든다.
    - 모든 회전을 전부 다 할 필요 없다. 사각형을 이루는 수만큼 Mod를 해주면 실질적으로 회전해야하는 회전수가 나온다.
    - 사각형을 이루는 갯수는 현재 사각형의 너비 - 다음 사각형의 너비이다. w*h - (w-2)*(h-2)
*/
public class w32_2_배열돌리기1_16926 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt(), R = sc.nextInt();
        int[][] arr = new int[N][M];

        int s = Math.min(N, M) / 2;

        for (int i = 0; i < R; i++) {
            rotateCounterClockwise(N, M, R, arr, s);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) sb.append(arr[i][j]).append(" ");
            sb.append("\n");
        }
        System.out.print(sb);

    }

    static void rotateCounterClockwise(int N, int M, int R, int[][] arr, int s) {

        for (int i = 0; i < s; i++) {
            int sx = i, sy = i;
            int temp = arr[sx][sy];
            for (int[] dir : new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}) {
                int nr = sx + dir[0], nc = sy + dir[1];

                if (nr < i && nc < i && nr >= N - i && nc >= M - i) {
                    arr[sx][sy] = arr[nr][nc];
                    sx = nr;
                    sy = nc;
                }
            }
            arr[i + 1][i] = temp;
        }
    }
}
