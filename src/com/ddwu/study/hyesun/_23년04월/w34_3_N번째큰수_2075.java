package com.ddwu.study.hyesun._23년04월;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

//https://www.acmicpc.net/problem/2075
public class w34_3_N번째큰수_2075 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());

        for(int i=0; i<n; i++) for(int j = 0; j<n; j++) q.offer(sc.nextInt());

        for(int i=0; i<n-1; i++) q.poll();

        System.out.println(q.poll());
    }
}