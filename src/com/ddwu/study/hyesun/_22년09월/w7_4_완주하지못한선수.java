package com.ddwu.study.hyesun._22년09월;

import java.util.HashMap;

//https://school.programmers.co.kr/learn/courses/30/lessons/42576

public class w7_4_완주하지못한선수 {
    public static String solution(String[] participant, String[] completion) {

        HashMap<String, Integer> map = new HashMap<>();
        for (String p : participant) map.put(p, map.getOrDefault(p, 0 ) +1);
        for (String c : completion)  map.put(c, map.get(c) -1);

        for (String key : map.keySet()) {
            if(map.get(key) ==0) continue;
            return key;
        }
        return "";
    }
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
        System.out.println(solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"}));
        System.out.println(solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}));

    }
}
