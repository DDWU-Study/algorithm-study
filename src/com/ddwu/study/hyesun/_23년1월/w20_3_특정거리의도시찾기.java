package com.ddwu.study.hyesun._23년1월;

import java.util.ArrayList;
import java.util.Scanner;

//https://www.acmicpc.net/problem/18352
/*
    출력값 :  X로부터 출발하여 도달할 수 있는 모든 도시 중에서, 최단 거리가 정확히 K인 모든 도시들의 번호를 출력

    알고리즘 선택이유
    모든 도로의 거리는 1이다 → 노드탐색 dfs/bfs
    최단거리 K+1이전에 종료 → bfs

    주의 : 단방향 그래프, 최단거리K도시가없으면 -1출력

   오답수정
   83% :

*/
public class w20_3_특정거리의도시찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt(), x = sc.nextInt();
        ArrayList[] adjListArray = new ArrayList[n + 1];
        ArrayList<ArrayList<Integer>> adjVector = new ArrayList<>(n + 1);

        for (int i = 0; i < n + 1; i++) adjListArray[i] = new ArrayList();
        for (int i = 0; i < n + 1; i++) adjVector.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            adjListArray[u].add(v);
            adjVector.get(u).add(v);
        }

        //최단거리(방문) 표시
        int[] dist = new int[n + 1];

        //bfs
        int answerCnt = 0;
        ArrayList<Integer> al = new ArrayList<>();
        java.util.Queue<int[]> q = new java.util.LinkedList<>();
        q.offer(new int[]{x, 0});
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int startNode = poll[0];
            int kan = poll[1];

            if (kan == k) {
                al.add(startNode);
            } else {
                for (int i : adjVector.get(startNode)) {
                    if (dist[i] == 0) {
                        dist[i] = kan + 1;
                        q.offer(new int[]{i, kan + 1});
                    }
                }
            }

        }
//        System.out.println(answerCnt==0 ? -1 : answerCnt);
        if (al.size() == 0) System.out.println(-1);
        al.stream().sorted().forEach(System.out::println);
    }
}