package com.ddwu.study.hyesun._23년1월;

import java.util.LinkedList;
import java.util.Scanner;

//https://www.acmicpc.net/problem/1260
/*
    간선을 연결하는 자료구조를 인접행렬을 이용해서 나타냈습니다
 */
public class w18_1_DFS와BFS_1260 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt(), M=sc.nextInt(), startV=sc.nextInt();
        int[][] adjMatrix=new int[N + 1][N + 1];

        while (M-->0) {
            int s=sc.nextInt(), e=sc.nextInt();
            adjMatrix[s][e]=adjMatrix[e][s]=1;
        }

        dfs_adjMatrix(adjMatrix, N, new boolean[N + 1], startV);
        bfs_adjMatrix(adjMatrix, N, M, new boolean[N + 1], startV, new LinkedList<Integer>());
    }


    static void dfs_adjMatrix(int[][] mat, int n, boolean[] visit, int v) {
        if(visit[v] == true) return;

        visit[v]=true;
        System.out.print(v + " ");

        for(int i=1; i<(n + 1); i++){
            if(!visit[i] && mat[v][i] == 1)
                dfs_adjMatrix(mat, n, visit, i);
        }

    }

    static void bfs_adjMatrix(int[][] mat, int n, int m, boolean[] visit, int v, LinkedList<Integer> Q) {
        System.out.println();
        visit[v]=true;
        Q.add(v);

        while (!Q.isEmpty()) {
            int node=Q.poll();
            System.out.print(node + " ");

            for(int i=1; i<(n + 1); i++)
                if(visit[i] == false && mat[node][i] == 1) {
                    visit[i]=true;
                    Q.offer(i);
                }
        }
    }
}
