package com.ddwu.study.hyesun._23년1월;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//https://www.acmicpc.net/problem/1697
/*

    1초 후에 X-1 또는 X+1로 이동
    순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동

    런타임 에러 (ArrayIndexOutOfBounds) 발생
    항상 범위확인 → 이미방문배열 확인하기
*/
public class w21_2_숨바꼭질1 {

    //164ms, 992B
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        boolean[] visit = new boolean[100001];
        Queue<int[]> q = new LinkedList<>(); //new int[]{현재위치, second}
        q.offer(new int[]{n, 0});
/*
        for (int i : new int[]{2 * n, n + 1, n - 1}) {
            if (i < 0 || i> 100000) continue;
            if (visit[i]) continue;
            visit[i] = true;
            q.offer(new int[]{i, 1});
        }
*/

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int nowX = poll[0], sec = poll[1];
            if (nowX < 0 || nowX > 100000 || visit[nowX]) continue;

            visit[nowX] = true;

            if (nowX == k) {
                System.out.println(sec);
                return;
            }

            for (int i : new int[]{2 * nowX, nowX + 1, nowX - 1}) {
                if (i < 0 || i > 100000) continue;
                if (visit[i]) continue;
                q.offer(new int[]{i, sec + 1});
            }

        }
    }

}

