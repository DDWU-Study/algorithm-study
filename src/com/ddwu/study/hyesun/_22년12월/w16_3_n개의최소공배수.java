package com.ddwu.study.hyesun._22년12월;

//https://school.programmers.co.kr/learn/courses/30/lessons/12953
/*
    (1) 유클리드 호제법
    (2) Gcd, Lcm 관계
    G * L 곱하면 → 두수(A*B)값 동일
    A=Ga, B=Gb 일때 AB=GGab
    Lcm(L) = Gab

    Python3 :
    (1) Math.gcd() 내장함수
     for n in num:
         lcm = n * lcm / Math.gcd(n, lcm)
     (2) 람다
         return reduce(lambda a, b : a * b // gcd(a, b), num)

 */
public class w16_3_n개의최소공배수 {

    static int gcd(int a, int b) { // 최대공약수,최소공배수용 유클리드 호제법
        int x = Math.max(a, b);
        int y = Math.min(a, b);

        while (x%y > 0) {
            int r =  x % y;
            x = y;
            y = r;
        }
        return y;
    }

    static int solution(int[] arr) {

        int lcm = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int G = gcd(arr[i], lcm);
            lcm = arr[i]*lcm/G;
        }

        return lcm;
    }
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2,6,8,14})); //168
        System.out.println(solution(new int[]{1,2,3})); //6
    }
}
