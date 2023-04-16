package com.ddwu.study.hyesun._23년04월;


import java.util.Scanner;

//https://www.acmicpc.net/problem/1254
public class w32_1_소수팰린드롬_1747 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();

        for(int i = n; ; i++) {
            if(isPalindrome(i) && isPrime(i)) {
                System.out.println(i);
                return;
            }
        }
    }

    static boolean isPalindrome(int n) {
        String num = Integer.toString(n);
        for(int i = 0; i <= num.length() / 2; i++) {
            if(num.charAt(i) != num.charAt(num.length() - i - 1)) return false;
        }
        return true;
    }

    static boolean isPrime(int n) {
        if(n == 1) return false;
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }
        return true;
    }


}
