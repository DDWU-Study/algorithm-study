package com.ddwu.study.hyesun._23년04월;

import java.text.ParseException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

//https://school.programmers.co.kr/learn/courses/30/lessons/92341
/*

 조건
 - 출차된 내역이 없다면, 23:59에 출차된 것으로 간주
 - 초과한 시간이 단위 시간으로 나누어 떨어지지 않으면, [[올림]]

 미와넛ㅇ

*/
public class w34_1_주차요금정산 {

    static int[] solution(int[] fees, String[] records) throws ParseException {
        // fee [기본 시간(분)	, 기본 요금(원),	단위 시간(분),	단위 요금(원)}
        int baseTime = fees[0];
        int baseFare = fees[1];
        int perTime = fees[2];
        int perFee = fees[3];

/*
        SimpleDateFormat sdf = new SimpleDateFormat("HH:MM");
        Date date = sdf.parse(records[0]);
        System.out.println(date.toString());
*/

        //차량별로 입출차 시간 모으기
        HashMap<Integer, List<Integer>> carMap = new HashMap<>();

        //05:34 5961 IN
        for (String record : records) {
            String[] s = record.split(" ");
            String[] hhmm = s[0].split(":");
            int hh = Integer.parseInt(s[0].substring(0, 2));
            int mm = Integer.parseInt(s[0].substring(3));

            int carNum  = Integer.parseInt(s[1]);


            List<Integer> list = carMap.getOrDefault(carNum, new LinkedList<>());
            list.add(hh*60 + mm);
            carMap.put(carNum, list);
        }

        //누적주차시간계산 -> 돈정산

        int[] answer = {};

        //차량 번호가 작은 자동차부터 청구할 주차 요금
        return answer;
    }


    public static void main(String[] args) throws ParseException {
        System.out.println(Arrays.toString(solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"})));
        System.out.println(Arrays.toString(solution(new int[]{120, 0, 60, 591}, new String[]{"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"})));
        System.out.println(Arrays.toString(solution(new int[]{1, 461, 1, 10}, new String[]{"00:00 1234 IN"})));

    }


}