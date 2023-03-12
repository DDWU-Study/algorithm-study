package com.ddwu.study.hyesun._23년03월;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

//https://www.acmicpc.net/problem/2583
/*

헷갈린 부분
M = 행렬의 행 = r좌표
N = 행렬의 열 = c좌표

학습할부분
꼭짓접만 보고 영역 방문표시하기

참고
https://coding-zzang.tistory.com/m/10
https://doongjeol.tistory.com/104
 */
//실패
public class w27_3_영역구하기_2583 {

    static boolean[][] markVisitedArea(boolean[][] paper, int sr, int scol, int er, int ec) {

        for (int r = sr; r < er; r++) {
            for (int c = scol; c < ec; c++) {
                paper[r][c] = true;
            }
        }

        return paper;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt(), k = sc.nextInt();
        boolean[][] paper = new boolean[m][n];
        //mark visited area
        for (int r = 0; r < m; r++)
            for (int c = 0; c < n; c++) {
                int sr = sc.nextInt();
                int scol = sc.nextInt();
                int er = sc.nextInt();
                int ec = sc.nextInt();

                paper = markVisitedArea(paper, scol, sr, ec, er);
            }


        // Count unvisited area
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = dfsCount(i, j, paper);
                al.add(count);
            }
        }


        System.out.println(al.size());
        al.sort(Comparator.comparingInt(o -> o));
        for (Integer i : al) System.out.print(i + " ");
    }

    private static int dfsCount(int r, int c, boolean[][] paper) {
        if (paper[r][c]) return 0;
        if (r < 0 || c < 0 || r >= paper.length || c >= paper[0].length) return 0;

        paper[r][c] = true;

        int retCnt = 1;
        for (int[] dir : new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}}) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (r < 0 || c < 0 || r >= paper.length || c >= paper[0].length) continue;
            if (paper[nr][c] == false) continue;
            retCnt += dfsCount(nr, nc, paper);
        }
        return retCnt;
    }
}
