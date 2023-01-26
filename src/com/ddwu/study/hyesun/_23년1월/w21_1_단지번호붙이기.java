package com.ddwu.study.hyesun._23년1월;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//https://www.acmicpc.net/problem/2667
/*
    고립1개 → 2부터 숫자매기기가 안됨 → 카운팅안됨 → 화면에서도 갱신안됨

    visit배열 + 1 = → 번호붙이기 2부터시작해서 별도배열없음
 */
public class w21_1_단지번호붙이기 {

    static int matrix[][],  N;
    //292ms
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        sc.nextLine();
        matrix = new int[N][N];
        for (int i = 0; i < N; i++)
            matrix[i] = Arrays.stream(sc.nextLine().split("")).mapToInt(Integer::parseInt).toArray();

        int totalDanzi = 1;
        ArrayList<Integer> alEachNum = new ArrayList<>();
        for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 1) {
                    ++totalDanzi;
                    int cnt = traverseDFS(i, j, new boolean[N][N], totalDanzi);
                    alEachNum.add(cnt);
                }
            }

        System.out.println(totalDanzi - 1); //alEachNum.size()
        Collections.sort(alEachNum); //오름차순 안해서 중간에 틀림
        alEachNum.forEach(System.out::println);


        for (int[] chars : matrix) System.out.println(Arrays.toString(chars));
    }

    private static int traverseDFS(int r, int c, boolean[][] visit, int number) {
//        if (r < 0 || c < 0 || r >= N || c >= N) return 0;
//        if(matrix[r][c] != 1) return 0;

        int retCnt = 1;
        matrix[r][c] = number;


        for (int[] d : new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}}) {
            int nr = r + d[0];
            int nc = c + d[1];


            if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
            if (matrix[nr][nc] != 1) continue; // ==0(막힘) +  이동한 memo 값

            matrix[nr][nc] = number;
            retCnt += traverseDFS(nr, nc, visit, number);

        }

        return retCnt;
    }

}
