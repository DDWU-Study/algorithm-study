package com.ddwu.study.hyesun._22년11월;

import java.util.Calendar;

//https://school.programmers.co.kr/learn/courses/30/lessons/12901
/*
    Calendar 클래스 설정 한계
     만약 문제에서 2016/1/1 금요일이라는 전제가 진짜 캘린더 요일이 아닌 다른 요일이었다면 적용하기 힘든 코드
 */

public class w13_5_2016년 {
    static String solution(int a, int b) {

        String[] calendar_dayOfWeek = {"", "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        String[] dayOfWeek = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        // 한계 :  만약 문제에서 2016/1/1 금요일이라는 전제가 진짜 캘린더 요일이 아닌 다른 요일이었다면 적용하기 힘든 코드이긴 합니다
        Calendar cal = Calendar.getInstance();
        cal.set(2016, a-1, b);
        int i = cal.get(Calendar.DAY_OF_WEEK);
        return calendar_dayOfWeek[i];

    }
    public static void main(String[] args) {
        System.out.println(solution(5,24));
    }
}
