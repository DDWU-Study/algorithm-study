package com.ddwu.study.hyesun._23년1월;


import java.util.*;

//https://www.acmicpc.net/problem/24444
/*

 */
public class w19_2_알고리즘수업bfs1_24444 {

    public static void main(String[] args) {
        //input -1
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt(), M=sc.nextInt(), startV=sc.nextInt();

        // graph data Structure
        ArrayList<ArrayList<Integer>> adjVector=new ArrayList<>();

        for(int i=0; i<N + 1; i++) adjVector.add(new ArrayList<>());

        //input -2 Edges
        for(int i=0; i<M; i++){
            int a=sc.nextInt(), b=sc.nextInt();
            adjVector.get(a).add(b);
            adjVector.get(b).add(a);
        }
        for(int i=1; i<=N; i++) Collections.sort(adjVector.get(i));

        // bfs
        int[] orderCnt=new int[N + 1];
        orderCnt[startV]=1;

        Queue<Integer> q=new LinkedList<>();
        int cnt=1;

        q.offer(startV);
        orderCnt[startV]=cnt++;

        while (!q.isEmpty()) {
            int a=q.poll();

            for(int i=0; i<adjVector.get(a).size(); i++){
                int nextV=adjVector.get(a).get(i);

                if(orderCnt[nextV] != 0)
                    continue;

                q.offer(nextV);
                orderCnt[nextV]=cnt++;
            }
        }

        //정답 출력
        for(int i=1; i<N + 1; i++) System.out.println(orderCnt[i]);

    }
}
