package com.ddwu.study.hyesun._23년02월;

import java.util.Scanner;
//https://www.acmicpc.net/problem/11048
/*
    미완성 ㅠ_ㅠ
*/
public class w25_3_이동하기_11048 {
    static int[][] memo;
    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt(), m=sc.nextInt();
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) map[i][j] = sc.nextInt();

        //solve
        int ansMax=0;
        ansMax=solveMemo(0, 0,n, m);


        System.out.println(ansMax);

    }

    private static int solveMemo(int r, int c, int n, int m) {
        if(r<0 || c<0 || r>=n || c>=m) return 0;
        if(memo[r][c] >0) return memo[r][c];
        if(r==n-1 && c==m-1) return memo[n-1][m-1];

        int retCnt=0;
        for (int[] dir : new int[][]{{1, 0}, {1, 1}, {0, 1}}) {
            int nr=r+dir[0], nc=c+dir[1];
            if(nr<0 || nc<0 || nr>=n || nc>=m) continue;

        }
        return memo[r][c] = retCnt;
    }

}
