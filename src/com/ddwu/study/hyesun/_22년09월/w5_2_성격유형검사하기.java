package com.ddwu.study.hyesun._22년09월;

import java.util.LinkedHashMap;
import java.util.Map;

/*
    map.put()과 map.replace()의 차이점
    - replace는 기존 key객체가 없으면 생성되지않고 넘어감
    - put()은 key가 없다면 새로 만든다
 */
public class w5_2_성격유형검사하기 {

    public static String solution(String[] survey, int[] choices) {

//        Map<Character, Integer> map = new LinkedHashMap<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < survey.length; i++) {
            String s1 = survey[i].split("")[0];
            String s2 = survey[i].split("")[1];

            Integer n1 = map.getOrDefault(s1, 0);
            Integer n2 = map.getOrDefault(s2, 0);

            if (choices[i] == 4) continue;
            else if (choices[i] < 4) {
                int p = -(choices[i] - 4);
                map.put(s1, n1 + p);
            } else
                map.put(s2, n2 + choices[i] - 4);
        }


        String answer = "";
        for (String[] arr : new String[][]{{"R", "T"}, {"C", "F"}, {"J", "M"}, {"A", "N"}}) {
            int point1 = map.getOrDefault(arr[0], 0);
            int point2 = map.getOrDefault(arr[1], 0);

            answer += (point1 < point2) ? arr[1] : arr[0];
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5}));
        System.out.println(solution(new String[]{"TR", "RT", "TR"}, new int[]{7, 1, 3}));
    }
}
