package com.ddwu.study.hyesun._22년10월;

//https://school.programmers.co.kr/learn/courses/30/lessons/42889
/*
    문제조건
    내림차순으로 스테이지의 번호가 담겨있는 배열을 return
    실패율 =  도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
    단, N + 1 은 마지막 스테이지(N 번째 스테이지) 까지 클리어 한 사용자를 나타낸다.

    헷갈림
    Long ▶ Double 형 나눗셈
    객체 implements Comparable<T> 에서 compareTo(0)함수 재정의

    오답수정
    77.8점 : 3,7(런타임),9,10,11(런타임),13개 오류 ▶ 0/n 방지
    88.9점 : 3,10,11 ㅠㅠㅠ 3일 ㅠㅠㅠ
      1) 비교 함수(compareTo) 비교값동일 return 0 😢
      2) ❓‍ 객체 자료형 Double -> double 변경 ❓


    간과/주의점
    실패율이 0이 나오는 부분이 있으므로 이 부분은 if문으로 실패율을 0으로 만들어주자.
    0이 나뉘는 것을 방지
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class w10_4_실패율 {
    static class RateIndex implements Comparable<RateIndex> {

        //        Double failRate;❓
        double failRate;
        int index;

        public RateIndex(int index, double failRate) {
            this.index = index;
            this.failRate = failRate;
        }

        @Override
        public int compareTo(RateIndex o) {
            if (this.failRate == o.failRate) return 0; //😢
            return this.failRate > o.failRate ? -1 : +1;
        }
    }

    static int[] solution(int N, int[] stages) {

        int totalPlayer = stages.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int step : stages) {
            Integer val = map.getOrDefault(step, 0);
            map.put(step, ++val);
        }

        ArrayList<RateIndex> list = new ArrayList<>();

        for (int i = 1; i < N + 1; i++) {

            Integer now = map.get(i);
            if (now == null) now = 0;

            double rate = (now == 0) ? 0 : (double) now / totalPlayer;
            list.add(new RateIndex(i, rate));
            totalPlayer -= now;
        }
        return list.stream().sorted().mapToInt(p -> p.index).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
        System.out.println(Arrays.toString(solution(4, new int[]{4, 4, 4, 4, 4})));

        System.out.println(Arrays.toString(solution(7, new int[]{1, 2, 3, 4, 5, 6})));
    }
}
