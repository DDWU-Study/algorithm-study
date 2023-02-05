package com.ddwu.study.hyesun._23년02월;

import java.util.Scanner;

//https://www.acmicpc.net/problem/2468
/*
    공부할부분 recurse
    - 리턴케이스에서 범위,방문여부를 체크하면 기존값에서 튕거나갈수있음
    - 리턴케이스~반복문 사이 부분 true설정은 1칸만 방문하는 경우를 대비 꼭 필요

    오답수정
    80% 부근 틀림 - 물의 높이가 0일 때 하나도 잠기지 않는 경우는 안전 영역 1개니까 최소 maxcnt를 1로 설정하니까 통
                ansMaxCount= 0 → 1로 변경 침수하나도 없는경우
 */
public class w22_2_안전영역_2468 {
    static int[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //input
        int N = sc.nextInt();
        map = new int[N][N];

        int heightMin = 101, heightMax=0;
        for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) {
            int n = map[i][j] = sc.nextInt();
            heightMin = Math.min(heightMin, n);
            heightMax = Math.max(heightMax, n);
        }

        //solve - 444ms
        int ansMaxCount=1;
        for (int h = heightMin; h < heightMax; h++) {
            int localCount=0;
            boolean[][] visit = new boolean[N][N];
            for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) {
                if(map[i][j] <= h) continue;
                if(visit[i][j]) continue;
                ++localCount;
                checkVisitDfs(visit, i, j, h);
            }
            if (ansMaxCount < localCount) {
                ansMaxCount = localCount;
            }
        }
        System.out.println(ansMaxCount);

    }

    private static void checkVisitDfs(boolean[][] visit, int r, int c, int height) {
//        if (visit[r][c]) return;
//        if (map[r][c] <= height) return;

        visit[r][c] = true;

        for (int[] d : new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}}) {
            int nr = r + d[0], nc = c + d[1];
            if (nr < 0 || nc < 0 || nr >= visit.length || nc >= visit.length) continue;
            if (visit[nr][nc]) continue;
            if (map[nr][nc] <= height) continue;

            visit[nr][nc] = true;
            checkVisitDfs(visit, nr, nc, height);
        }
    }
}
