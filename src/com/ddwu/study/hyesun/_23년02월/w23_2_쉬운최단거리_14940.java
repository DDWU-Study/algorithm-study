package com.ddwu.study.hyesun._23년02월;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

//https://www.acmicpc.net/problem/14940      `
public class w23_2_쉬운최단거리_14940 {
    static int n, m, map[][], cnt[][];
    static boolean visit[][];
    static int dy[] = {0, 0, 1, -1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        cnt = new int[n][m];
        visit = new boolean[n][m];

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 2) {
                    q.offer(i);
                    q.offer(j);
                    visit[i][j] = true;
                }
            }
        while (!q.isEmpty()) {
            int r = q.poll();
            int c = q.poll();

            for (int[] d : new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}}) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (!(nr >= 0 & nr < n && nc >= 0 && nc < m)) continue;
                if (visit[nr][nc]) continue;
                if (map[nr][nc] == 0) continue;

                q.offer(nr);
                q.offer(nc);
                visit[nr][nc] = true;
                cnt[nr][nc] = cnt[r][c] + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(map[i][j] != 0 && !visit[i][j] ? -1 : cnt[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

}
