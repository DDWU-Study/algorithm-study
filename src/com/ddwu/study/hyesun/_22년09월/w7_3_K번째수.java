package com.ddwu.study.hyesun._22년09월;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

//https://school.programmers.co.kr/learn/courses/30/lessons/42748
public class w7_3_K번째수 {
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int count = 0;
        for (int[] c : commands) {
            ArrayList<Integer> al = new ArrayList<>();
            for (int i = c[0] - 1; i < c[1]; i++) //🍕 +2
                al.add(array[i]);
            al.sort(Comparator.comparingInt(o -> o));
            answer[count++] = al.get(c[2]-1);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                solution(new int[]{1, 5, 2, 6, 3, 7, 4},
                        new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}})
        ));
        ;
    }
}
