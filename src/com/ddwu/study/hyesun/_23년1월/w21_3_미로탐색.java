package com.ddwu.study.hyesun._23년1월;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//https://www.acmicpc.net/problem/2178
/*
    (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수
    -> (0,0)으로 시작
    칸을 셀 때에는 시작 위치와 도착 위치도 포함
*/
public class w21_3_미로탐색 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();sc.nextLine();
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] arr = sc.nextLine().toCharArray();
            for (int j = 0; j < M; j++) map[i][j] = arr[j] & 15;
        }

        System.out.println(bfs(map));
    }

    // 144ms
    static int bfs(int[][] map) {

        // new int[] {가로좌표, 세로좌표}
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        map[0][0] = 0; // 개수1이면
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int r=poll[0], c=poll[1];

            for (int[] d : new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}}) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nc < 0 || nr >= map.length || nc >= map[0].length) continue;
                if(map[nr][nc] != 1) continue;

//                map[nr][nc] = count +1;
                if(r==0 && c==0) map[nr][nc] = 2; //1이면 무한루프에 빠질수 있으므로 방지
                else map[nr][nc] = map[r][c] +1;

                q.offer(new int[]{nr, nc});
            }
        }
        return map[map.length - 1][map[0].length - 1];
    }
}
