package com.ddwu.study.hyesun._22년08월;
// 총합이 45 고정
public class w3_2_없는숫자더하기 {
    public static int solution(int[] numbers) {
        int answer = 45;
        for (int n : numbers) {
            answer -= n;
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,3,4,6,7,8,0}));
        System.out.println(solution(new int[]{5,8,4,0,6,7,9}));
    }
}
