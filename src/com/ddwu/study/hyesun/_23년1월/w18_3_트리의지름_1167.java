package com.ddwu.study.hyesun._23년1월;

import java.util.ArrayList;
import java.util.Scanner;

//https://www.acmicpc.net/problem/1167
/*
    간서정보를 연결리스트 list[시작노드]의 배열로 연결
 */
public class w18_3_트리의지름_1167 {

    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int max = 0, node;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        list = new ArrayList[n + 1];
        for(int i = 1; i < n + 1; i++) list[i] = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int s = sc.nextInt();
            while(true) {
                int e = sc.nextInt();
                if(e == -1) break;
                int cost = sc.nextInt();
                list[s].add(new Node(e, cost));
            }
        }

        visited = new boolean[n + 1];
        dfs(1, 0);

        visited = new boolean[n + 1];
        dfs(node, 0);

        System.out.println(max);
    }

    public static void dfs(int x, int len) {
        if(len > max) {
            max = len;
            node = x;
        }
        visited[x] = true;

        for(int i = 0; i < list[x].size(); i++) {
            Node n = list[x].get(i);
            if(visited[n.vertex] == false) {
                dfs(n.vertex, n.cost + len);
                visited[n.vertex] = true;
            }
        }
    }

    static class Node {
        int vertex, cost;
        public Node(int vertex, int cost) {
            this.vertex=vertex;
            this.cost = cost;
        }
    }
}
