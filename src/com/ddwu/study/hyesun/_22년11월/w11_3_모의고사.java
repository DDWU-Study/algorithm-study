package com.ddwu.study.hyesun._22년11월;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

//https://school.programmers.co.kr/learn/courses/30/lessons/42840
/*
    1번 : 길이5 : 1, 2, 3, 4, 5
    2번 : 길이8 : 2, 1, 2, 3, 2, 4, 2, 5
    3번 : 길이10: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5

    오답수정
    85.7점 : 8번, 14번
        -최대값의 학생만 구하는 겁니다. 학생들이 몇개 맞췄 는지 나열❌
        - 반례 : [3, 3, 2, 1, 5] -> [3] , 오답은 [1,2]
        - 원인 : 버블정렬 -> [0]을 최대로 봄

 */
public class w11_3_모의고사 {
    static int[] solution(int[] answers) {

        if(answers.length == 0 ) return new int[]{1,2,3};

        //3명 찍는방식 배열담기
/*
        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
*/

        // j번학생 (1, 2번...)
        int[][] students = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int[] score = {0, 0, 0};
        for (int i = 0; i < answers.length; i++) {
            int ansNum = answers[i];
            for (int j = 0; j < students.length; j++) {
                int markNum = students[j][i % students[j].length];
                if (ansNum == markNum)
                    ++score[j];
            }
        }

        // Max Score
        int max=score[0];
        for (int i = 1; i < 3; i++) max = Math.max(max, score[i]);

//        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> map = new LinkedHashMap<>();
        for (int i = 0; i < 3; i++) {
            ArrayList<Integer> indexList = map.getOrDefault(score[i], new ArrayList<>());
            indexList.add(i+1); // Index starts with 1
            map.put(score[i], indexList);
        }
        return map.get(max).stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(solution(new int[]{1, 3, 2, 4, 2})));

        System.out.println("----8번 반례 ---");
        System.out.println(Arrays.toString(solution(new int[]{3, 3, 2, 1, 5})));
        System.out.println(Arrays.toString(solution(new int[]{5, 5, 4, 2, 3})));
    }
}
