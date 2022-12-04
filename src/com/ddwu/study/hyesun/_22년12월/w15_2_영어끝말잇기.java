package com.ddwu.study.hyesun._22년12월;

import java.util.Arrays;
import java.util.HashSet;

//https://school.programmers.co.kr/learn/courses/30/lessons/12981
public class w15_2_영어끝말잇기 {
    static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashSet<String> usedMap = new HashSet<>();

        // 1글자
        if (words[0].length() <= 1)
            return new int[]{1,1};
        else usedMap.add(words[0]);

        for (int i = 1; i < words.length; ++i) {
            String word = words[i];

            if (word.length() <= 1 || word.charAt(0) != words[i - 1].charAt(words[i - 1].length() - 1) || usedMap.contains(word)) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                return answer;
            } else {
                usedMap.add(word);
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})));
        System.out.println(Arrays.toString(solution(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"})));
        System.out.println(Arrays.toString(solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"})));
    }
}
