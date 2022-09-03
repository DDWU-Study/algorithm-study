package com.ddwu.study.hyesun._22년09월;

import java.util.Arrays;
import java.util.LinkedList;

public class w5_3_같은숫자는싫어 {
    public static int[] solution(int []arr) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            int d=i +1;
            while (d< arr.length && arr[i] == arr[d])
                ++d;
            list.add(arr[d-1]);
            i = d-1;
        }

        //동적 → 정적 int[] 담기
        return list.stream().mapToInt(i -> i).toArray();
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 1, 3, 3, 0, 1, 1})));
        System.out.println(Arrays.toString(solution(new int[]{4, 4, 4, 3, 3})));
    }
}
