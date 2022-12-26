package com.ddwu.study.hyesun._22년12월;

import java.util.HashSet;

//https://school.programmers.co.kr/learn/courses/30/lessons/43162?language=java
/*

    A, B, C는 모두 같은 네트워크
    정답 :  네트워크의 개수를 return

    오답수정
    15점 :  int num = group[i] > 0 ? group[i] : ++answerNum;
    30점 : unionFind

 */
public class w17_4_네트워크 {
    static int solution(int n, int[][] computers) {
        return approach1_5(n, computers); //DFS

    }

    private static int approach1_5(int n, int[][] computers) {

        boolean[] visit = new boolean[n];
        int ansCount = 0;
        for (int i = 0; i < computers.length; i++) {
            if (visit[i] == false) {
                ++ansCount;
                dfs(i, visit, computers);
            }

        }
        return ansCount;
    }

     static void dfs(int num, boolean[] visit, int[][] computers) {
        if(visit[num])
            return;

        visit[num] = true;

        for (int j = 0; j < computers[num].length; j++) {
            if (computers[num][j] == 1) {
                dfs(j, visit, computers);
            }
        }

    }
    public static void main(String[] args) {
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}})); //2
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}})); //1
    }
}
