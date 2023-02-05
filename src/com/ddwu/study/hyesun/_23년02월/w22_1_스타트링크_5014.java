package com.ddwu.study.hyesun._23년02월;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//https://www.acmicpc.net/problem/5014
/*

 */
public class w22_1_스타트링크_5014 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int F = sc.nextInt(), S = sc.nextInt(), G = sc.nextInt(), U = sc.nextInt(), D = sc.nextInt();
        int[] arr = new int[F + 1];
        System.out.println(BFS(F, S, G, U, D, arr));

    }

    public static String BFS(int Floor, int start, int end, int up, int down, int[] arr) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        arr[start] = 1;

        while (!q.isEmpty()) {
            int current = q.poll();
            if (current == end) {
                return String.valueOf(arr[current] - 1);
            }
            if (current + up <= Floor) {
                if (arr[current + up] == 0) {
                    arr[current + up] = arr[current] + 1;
                    q.add(current + up);
                }

            }
            if (current - down > 0) {
                if (arr[current - down] == 0) {
                    arr[current - down] = arr[current] + 1;
                    q.add(current - down);
                }
            }
        }
        return "use the stairs";
    }
}