package com.ddwu.study.hyesun._22년12월;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.PriorityQueue;

//https://school.programmers.co.kr/learn/courses/30/lessons/42628
/*
    결과
    큐가 비어있으면 [0,0] 비어있지 않으면 [최댓값, 최솟값]
    
    제한사항
    - 최댓값/최솟값이 둘 이상인 경우, 하나만 삭제
    - empty큐 + D연산 = 무시
    
    궁금중
    큐 안의 값이 모두 동일 → max ==min 이면 ? → 1개만삭제

    오답수정
    83.3점 : 1번 : 큐2개 : 최댓값삭제후 min 큐 남아있는데 더큰수들이 들어온수 -1-1 면산으로 이중삭제
 */
public class w16_5_이중우선순위큐 {

    static int[] solution(String[] operations) {
        PriorityQueue<Integer> minPq = new PriorityQueue<>((Comparator.comparingInt(o -> o)));
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(((o1, o2) -> o2 - o1));

        LinkedHashMap<Integer, Integer> usedMap = new LinkedHashMap();

        for (String str : operations) {
            String[] s = str.split(" ");
            if (s[0].equals("I")) {
                int num = Integer.parseInt(s[1]);
                minPq.add(num);
                maxPq.add(num);
//                usedMap.put(num, usedMap.getOrDefault(num, 0) + 1);
            } else {
                if (minPq.size() == 0) continue;
                if (minPq.peek() == maxPq.peek()) minPq.poll();
                else if (s[1].startsWith("1")) {
                    int peek = maxPq.peek();
                    maxPq.poll();
                    minPq.remove(peek);
                } else {
                    int peek = minPq.peek();
                    minPq.poll();
                    maxPq.remove(peek);
                }
            }
        }

        if (minPq.size() == 0) return new int[]{0, 0};
        return new int[]{maxPq.peek(), minPq.peek()};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"})));
        System.out.println(Arrays.toString(solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"})));

        System.out.println(Arrays.toString(solution(new String[]{"I 4", "I -1", "I 6", "I 3"})));
        System.out.println(Arrays.toString(solution(new String[]{"I 10", "I 20", "D 1", "I 30", "I 40", "D -1", "D -1"}))); //정답[40,40], 내오답 [40,30]
    }

}
