package com.ddwu.study.hyesun._23년1월;

import java.util.LinkedList;
import java.util.Scanner;

//https://www.acmicpc.net/problem/2178
/*

    2차원배열에서  이동을위해 2차원배열 사용
    {{1, 0}, {0, 1}, {-1, 0}, {0, -1}} //남동북서

    값이 2개뿐 -> 방문배열대신 이동했으면 0으로 변경

    큐에 들어가는 값 [가로좌표, 세로좌표, 이동칸수]

    결과 : 지나야 하는 최소의 칸 수
 */
public class w18_2_미로탐색_2178 {

    static char[][] mirror;
    static int d[][]={{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(), m=sc.nextInt();
        sc.nextLine();
        mirror=new char[n][m];
        for(int i=0; i<n; i++) mirror[i]=sc.nextLine().toCharArray();

        System.out.println(bfs(n, m, new LinkedList<>()));
    }

    static int bfs(int n, int m, LinkedList<int[]> q) {

        q.offer(new int[]{0, 0, 1});
        mirror[0][0]='0';
        while (!q.isEmpty()) {
            int[] pop=q.poll();

            for(int[] d : d){
                int ni=pop[0] + d[0], nj=pop[1] + d[1];
                if(ni<0 || nj<0 || ni>=n || nj>=m || mirror[ni][nj] == '0') continue;
                if(ni == n - 1 && nj == m - 1) return pop[2] + 1;
                mirror[ni][nj]='0'; //방문배열대신 값변경
                q.offer(new int[]{ni, nj, pop[2] + 1});
            }
        }
        return -1;
    }
}
