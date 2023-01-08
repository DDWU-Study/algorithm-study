package com.ddwu.study.hyesun._23년1월;


import java.util.*;

//https://www.acmicpc.net/problem/2606

public class w19_3_바이러스_2606 {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(), m=sc.nextInt();

        int[][] adjMatrix=new int[n + 1][n + 1];
        for(int i=0; i<m; i++){
            int a=sc.nextInt(), b=sc.nextInt();
            adjMatrix[a][b]=adjMatrix[b][a]=1; // ★
        }

        Queue<Integer> q=new LinkedList<>();
        boolean[] visit=new boolean[n + 1];

        q.add(1);
        visit[1]=true;

        int count=0;
        while (!q.isEmpty()) {
            int v=q.poll();
            for(int i=1; i<=n; i++){
                if(adjMatrix[v][i] == 1 && !visit[i]) {
                    visit[i]=true;
                    q.add(i);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}