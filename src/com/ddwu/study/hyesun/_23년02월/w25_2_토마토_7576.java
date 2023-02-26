package com.ddwu.study.hyesun._23년02월;


import java.util.ArrayDeque;
import java.util.Scanner;

//https://www.acmicpc.net/problem/7576
/*
    BFS - 큐의 사이즈가 0까지 다 빼면 1회차 완료 while(size-->0)
    ansRound답 :  며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수
*/
public class w25_2_토마토_7576 {
    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] box = new int[n][m];
        int totalTomato = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                int k = box[i][j] = sc.nextInt();
                if (k == 0)
                    ++totalTomato;
            }

        if (totalTomato ==0) {
            System.out.println(0);
            return;
        }

        //solve - 1436ms
        int ansRound = -1; //-1에서 시작
        //1회차(round) 토마토 담기
        ArrayDeque<int[]> q = new ArrayDeque<>(); // int[] {가로, 세로}
        for (int r = 0; r < n; r++)
            for (int c = 0; c < m; c++) {
                if (box[r][c] == 1)
                    q.add(new int[]{r, c});
            }

        while (!q.isEmpty()) {
            int size = q.size();
            ++ansRound;
            while (size-- > 0) {
                int[] poll = q.poll();
                int r = poll[0], c = poll[1];

                for (int[] dir : new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}}) {
                    int nr = r + dir[0], nc = c + dir[1];
                    if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;

                    if (box[nr][nc] != 0) continue;
                    box[nr][nc] = 1;
                    --totalTomato;
                    q.add(new int[]{nr, nc});

                }
            }
        }
        System.out.println(totalTomato > 0 ? -1 : ansRound);

    }

}
