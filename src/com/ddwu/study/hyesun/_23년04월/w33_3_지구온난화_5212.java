package com.ddwu.study.hyesun._23년04월;

import java.util.Scanner;

//https://www.acmicpc.net/problem/5212
/*

    https://baelanche.tistory.com/50
*/
public class w33_3_지구온난화_5212 {
        static char[][] a, b;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();
        a = new char[r+2][c+2];
        b = new char[r+2][c+2];

        for(int i=0; i<r+2; i++) for(int j=0; j<c+2; j++) a[i][j] = '.';

        for(int i=1; i<r+1; i++) {
            char[] ch = sc.next().toCharArray();
            for(int j=1; j<c+1; j++) a[i][j] = ch[j-1];
        }

        for(int i=0; i<r+2; i++) {
            for(int j=0; j<c+2; j++) {
                b[i][j] = a[i][j];
            }
        }

        for(int i=1; i<r+1; i++) {
            for(int j=1; j<c+1; j++) {
                dfs(i, j);
            }
        }

        int sRow = 0, eRow = 0;
        int sCol = 0, eCol = 0;
        for(int i=0; i<r+2; i++) {
            for(int j=0; j<c+2; j++) {
                if(b[i][j] == 'X' && sRow == 0) sRow = i;
                if(b[i][j] == 'X') {
                    if(eRow < i)
                        eRow = i;
                }
            }
        }

        for(int i=0; i<c+2; i++) {
            for(int j=0; j<r+2; j++) {
                if(b[j][i] == 'X' && sCol == 0) sCol = i;
                if(b[j][i] == 'X') {
                    if(eCol < i)
                        eCol = i;
                }
            }
        }

        for(int i=sRow; i<=eRow; i++) {
            for(int j=sCol; j<=eCol; j++) {
                System.out.print(b[i][j]);
            }
            System.out.println();
        }
    }

    public static void dfs(int x, int y) {
        if(a[x][y] == '.') return;

        int cnt = 0;
        if(a[x-1][y] == '.') cnt++;
        if(a[x][y-1] == '.') cnt++;
        if(a[x][y+1] == '.') cnt++;
        if(a[x+1][y] == '.') cnt++;

        if(cnt >= 3)
            b[x][y] = '.';
    }
}