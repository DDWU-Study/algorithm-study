package com.ddwu.study.hyesun._22년12월;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.acmicpc.net/problem/11724
/*
    플로이드워샬, dfs, bfs
    https://velog.io/@lifeisbeautiful/%EB%B0%B1%EC%A4%80-11724%EB%B2%88-%EC%97%B0%EA%B2%B0-%EC%9A%94%EC%86%8C%EC%9D%98-%EA%B0%9C%EC%88%98-Java

    이해 안가는 부분
    1. dfs 내부 j 반복문 돌릴때 visit 체크 안하는 이유?
    2. dfs 재귀 직전에 true 왜 삭제?
* */
public class w17_4_2_연결요소의개수 {
    static void DFS(int num, boolean[] visit, int[][] adjMatrix) {
        if (visit[num]) return;

        visit[num] = true;

        for (int j = 1; j <adjMatrix.length; j++) {
//            if (visit[j] == false || adjMatrix[num][j] == 1) {
            if (adjMatrix[num][j] == 1) {
//                visit[j] = true;
                DFS(j, visit, adjMatrix);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();

        //adjMatrix
        int[][] adjMatrix = new int[N + 1][N + 1];

        //adjList
        ArrayList[] adjList = new ArrayList[N + 1];
        for (int i = 0; i < adjList.length; i++) adjList[i] = new ArrayList();

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            adjMatrix[a][b] = 1;
            adjMatrix[b][a] = 1;

            adjList[a].add(b);
            adjList[b].add(a);
        }

        //DFS
        boolean[] visit = new boolean[N + 1];
        int ansCount = 0;
        for (int i = 1; i < (N + 1); i++) {
            if (visit[i] == false) {
                ++ansCount;
                DFS(i, visit, adjMatrix);
            }
        }

        System.out.println(ansCount);
    }


}
