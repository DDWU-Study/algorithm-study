package com.ddwu.study.hyesun._22년09월;
/**
 * 주의점 : long 타입, -1반환, 1,2방법 끝지정, 2중간에 초과되면 return
 * <p>
 * 풀이1. 동적 리스트로 풀지말고, int[]에서 인덱스로 계산 → 투포인터?? → 2번째방법
 */

import java.util.ArrayDeque;
import java.util.Queue;

//https://school.programmers.co.kr/learn/courses/30/lessons/118667

public class w5_1_두큐합같게만들기 {
    public static int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        long s1=0, s2=0, sum;
        for (int tmp : queue1) {q1.add(tmp); s1+=tmp;}
        for (int tmp : queue2) {q2.add(tmp); s2+=tmp;}
        sum = s1+s2;
        if (sum%2==1) return -1;
        sum/=2;
        int p1 = 0, p2 = 0, limit = queue1.length*2;
        while (p1<=limit && p2<=limit) {
            if (s1 == sum) return p1+p2;
            if (s1>sum) {
                s1-=q1.peek();
                s2+=q1.peek();
                q2.add(q1.poll());
                p1++;
            } else {
                s2-=q2.peek();
                s1+=q2.peek();
                q1.add(q2.poll());
                p2++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1}));
        System.out.println(solution(new int[]{1, 2, 1, 2}, new int[]{1, 10, 1, 2}));
        System.out.println(solution(new int[]{1, 1}, new int[]{1, 5}));
    }
}
