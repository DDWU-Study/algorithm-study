package com.ddwu.study.hyesun._22년12월;

//https://school.programmers.co.kr/learn/courses/30/lessons/12980
/*

    정답 : 건전지 사용량의 최솟값 =  점프로 이동하는 것은 최소 (1칸당 1사용량)
    이동방법 :  한 번에 K 칸을 앞으로 점프,  (현재까지 온 거리) x 2 에 해당하는 위치로 순간이동


    풀이
    예제 1,2를 홀짝일때 +1차이
    순간이동은 X2, 할때 홀수면 1칸점프후 2제곱순간이동
    시작점~0까지 거꾸로 계산
 */
public class w17_2_점프와순간이동 {
    static int solution(int n) {
        int ans = 0;

        while (n > 0) {
            while (n % 2 == 0) n /= 2; //2제곱 순간이동
            --n;
            ++ans;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solution(5));
        System.out.println(solution(6));
        System.out.println(solution(5000));
    }
}
