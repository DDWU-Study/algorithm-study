package com.ddwu.study.hyesun._23년02월;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

//미완
/*
    자식 → 부모 단방향 그래프 (부모는 한명만 주어진다)
    case1) 직계조상(부모노트는 안 움직여야)
    case2) 방계친척(공통노드 나올때까지 모든 노드 같이

    궁굼증
    양방향 그래프면 visit[]배열로 재방문을 막는데
    단방향 그래프면 visit[] 없이도 구현 가능할까..?

    graph 구현
    인접행렬안한이유 :  자식 → 부모 1개라 희소행렬
 */
public class w23_3_촌수계산_2644 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt(), a=sc.nextInt(), b=sc.nextInt();
        int relations = sc.nextInt();

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>(); // 양방향
        int[][] adjMatrix = new int[n+1][n+1];
        while (relations-- > 0) {
            int parent = sc.nextInt(), sibling=sc.nextInt();
            ArrayList<Integer> val = map.getOrDefault(sibling, new ArrayList<>());
            val.add(parent);
            map.put(sibling, val);
            adjMatrix[sibling][parent] = 1;

            //양방향 만들기
//            map.put(parent, sibling);
            ArrayList<Integer> val2 = map.getOrDefault(parent, new ArrayList<>());
            val.add(sibling);
            map.put(parent, val2);
            adjMatrix[parent][sibling] = 1;
        }

        //양방향으로 만들되 되돌아가지 않기
        boolean[] visit = new boolean[n + 1];
        int answerSu=0;

        getChonsuByBFS(a, b, map, visit, answerSu);
    }

    private static void getChonsuByBFS(int a, int b, HashMap<Integer, ArrayList<Integer>> map, boolean[] visit, int answerSu) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(a);
        visit[a] = true;
        while ( ! q.isEmpty()) {
            Integer poll = q.poll();
            ++answerSu;
            for (Integer i : map.get(poll)) {
                if(visit[i]) continue;
                if (i == b) {
                    System.out.println(answerSu + 1);
                    return;
                }
                visit[i] = true;
                q.offer(i);
            }

        }


        System.out.println(answerSu ==0 ? -1 : answerSu);
    }

}