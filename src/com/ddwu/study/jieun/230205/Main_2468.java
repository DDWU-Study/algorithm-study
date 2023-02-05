package boj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2468 {
    static int[][] map;
    static int N;
    static boolean[][] visited;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        int h_max = 0;
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';
                h_max = Math.max(h_max, map[i][j]);
            }
        }

        int max = 0;
        for(int i = 1; i <= h_max; i++) {
            visited = new boolean[N][N];
            visited[0][0] = true;
            max = Math.max(max, bfs(0, 0, i));
        }

        System.out.println(max);
    }

    public static int bfs(int x, int y, int h) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x,y});
        int cnt = 1;
        while(!q.isEmpty()) {
            int now[] = q.remove();
            int nowX = now[0];
            int nowY = now[1];

            for(int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N || visited[nextX][nextY])
                    continue;
                if (map[nextX][nextY] > h) {
                    visited[nextX][nextY] = true;
                    q.add(new int[] {nextX, nextY});
                    cnt++;
                } else {
                    visited[nextX][nextY] = true;
                }
            }
        }
        System.out.println(cnt);
        return cnt;
    }
}
