package com.ddwu.study.hyesun._22년08월;

import java.util.HashMap;
import java.util.Map;
/*
    1. Map<String, Integer> 로 설정해서 단어 3-5개씩 인덱스쪼갬
    2. Map<String, String> 숫자를 문자열로
 */
public class w2_2_숫자문자열과영단어 {
    public int solution(String s) {

        //문자열값을
        Map<String, String> map = new HashMap<>();
        map.put("zero", "0"); map.put("one", "1"); map.put("two", "2"); map.put("three", "3"); map.put("four", "4");
        map.put("five", "5"); map.put("six", "6"); map.put("seven", "7"); map.put("eight", "8");map.put("nine", "9");

        // 문자열 "0" - "9" 까지 순회하면서 String에서 값교체
        for (String key : map.keySet()) {
            s = s.replaceAll(key, map.get(key));
        }
        int answer = Integer.parseInt(s); //문자열 숫자변환
        return answer;
    }

}
