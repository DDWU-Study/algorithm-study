package com.ddwu.study.hyesun._23년1월;

import java.util.LinkedList;
import java.util.Queue;

//https://school.programmers.co.kr/learn/courses/30/lessons/1844
/*
    정답 : 지나가야 하는 칸의 개수의 최솟값, 도착불가하면 -1

    문제 : 2차원행렬 최소거리, 칸이동 모두1이므로 bfs,dfs

    풀이방법
    -문제는 (1,1)~(n,m)시작이라 하지만 좌표값출력이아니므로 (0,0)~(n-1,m-1)탐색
    -행렬값 2개 → 별도 방문배열없음
    1. bfs - int[]{가로좌표, 세로좌표, 이동거리}
    2. bfs - int[]{가로좌표, 세로좌표}, 이동거리는 2차원배열에 직접입력

*/
public class w20_2_게임맵최단거리 {
    static int solution(int[][] maps) {
//        return bfs_kanQueue(maps);
        return bfs_kanMemo(maps);
    }

    private static int bfs_kanMemo(int[][] maps) {
        int n = maps.length, m = maps[0].length;

        //bfs - int[]{가로좌표, 세로좌표}
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        maps[0][0] = 1;
        while ( ! q.isEmpty()) {
            int[] poll = q.poll();
            int r=poll[0], c=poll[1];
            int kan = maps[r][c];

            // 동서남북 이동
            for (int[] d : new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}}) {
                int nr= r + d[0];
                int nc= c + d[1];

                //범위검사
                if(nr<0 || nc<0 || nr>=n || nc>=m) continue;
                //이미 방문검사
                if(maps[nr][nc] != 1 ) continue; // ==0(막힘) +  이동한 memo 값

//                maps[nr][nc] = 0; //이미방문 0으로 변경
                maps[nr][nc] = kan +1;
                q.add(new int[]{nr, nc, kan+1});

                if(nr==n-1 && nc==m-1)
                    return kan + 1;
            }

        }

        return -1;
    }

    private static int dfs_kanMemo(int[][] maps, int r, int c) {
        int n = maps.length, m = maps[0].length;
        if (r == n - 1 && c == m - 1) return 1;
        if(r<0 || c<0 || r>=n || c>=m) return 0;

        maps[r][c] = 0;

        int retKan = 0;
        for (int[] d : new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}}) {
            int nr = r + d[0];
            int nc = c + d[1];

            //범위검사
            if(nr<0 || nc<0 || nr>=n || nc>=m) continue;
            //이미 방문검사 (1이상)
            if(maps[nr][nc] != 1 ) continue; //(X)  >= 1

            maps[r][c] = 0;
            retKan += 1 + dfs_kanMemo(maps, nr, nc);

        }
        if(maps[r][c] == 0) return -1;
        return maps[r][c] = retKan +1;
    }

    static int bfs_kanQueue(int[][] maps) {
        int n = maps.length, m = maps[0].length;

        //bfs - int[]{가로좌표, 세로좌표, 이동거리}
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 1});
        while ( ! q.isEmpty()) {
            int[] poll = q.poll();
            int r=poll[0], c=poll[1], kan = poll[2];

            // 동서남북 이동
            for (int[] d : new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}}) {
                int nr= r + d[0];
                int nc= c + d[1];

                //범위검사
                if(nr<0 || nc<0 || nr>=n || nc>=m) continue;
                //이미 방문검사
                if(maps[nr][nc] == 0 ) continue;

                maps[nr][nc] = 0; //이미방문 0으로 변경
                q.add(new int[]{nr, nc, kan+1});

                if(nr==n-1 && nc==m-1)
                    return kan + 1;
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1}, {0,0,0,0,1}}));
        System.out.println(solution(new int[][]{{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,0}, {0,0,0,0,1}}));

    }
}