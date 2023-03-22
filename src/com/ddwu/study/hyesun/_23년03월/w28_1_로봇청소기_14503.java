package com.ddwu.study.hyesun._23년03월;

import java.util.Scanner;

//https://www.acmicpc.net/problem/
/*

    조건
    처음에 빈 칸은 전부 청소되지 않은 상태

    $0$인 경우 북쪽, $1$인 경우 동쪽, $2$인 경우 남쪽, $3$인 경우 서쪽을 바라보고 있는 것
    []=1 벽, []=0 빈칸

    정답  작동을 시작한 후 작동을 멈출 때까지 청소하는 칸의 개수
    
    참고
    https://moonsbeen.tistory.com/12
 */
public class w28_1_로봇청소기_14503 {

    static int N, M, map[][];

    public static void main(String[] args) {

        //input
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        int rr = sc.nextInt(), rc = sc.nextInt(), dir = sc.nextInt();
        map = new int[N][M];
        for (int i = 0; i < N; i++) for (int j = 0; j < M; j++) map[i][j] = sc.nextInt();

        System.out.println(recurseDfs(rr, rc, dir, 0));

    }

    private static int recurseDfs(int r, int c, int dir, int count) {
        map[r][c] = 2; //청소완료

        for (int[] d : new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}}) {

            dir -= 1; //왼쪽 방향으로 돌면서 탐색
            if (dir == -1) dir = 3;

            int nx = r + d[dir];
            int ny = c + d[dir];
            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (map[nx][ny] == 0) {
                    return recurseDfs(nx, ny, dir, count + 1);
                }
            }


            //반대방향으로 후진
            int dward = (dir + 2) % 4;
            int bx = r + d[dward];//후진
            int by = c + d[dward];//후진
            if (bx >= 0 && by >= 0 && bx < N && by < M && map[bx][by] != 1) {
                recurseDfs(bx, by, dir, count); //후진할 때 방향을 유지해야 한다.
            }
        }

        return count;
    }
}
