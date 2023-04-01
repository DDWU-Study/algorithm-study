package com.ddwu.study.hyesun._23년03월;

import java.util.Scanner;

//https://www.acmicpc.net/problem/14501
/*

 */
public class w28_2_퇴사_14501 {
    static int n, max;
    static int[] time,value;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        time = new int[n];
        value = new int[n];
        for(int i=0;i<n;i++) {
            time[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }
        max = Integer.MIN_VALUE;
        recurse(0,0);
        System.out.println(max);
    }


    static void recurse(int index, int value) {
        if(index>n) return;
        if(index==n) {
            max = Math.max(max, value);
            return;
        }
        recurse(index+time[index],value+ w28_2_퇴사_14501.value[index]);
        recurse(index+1,value);
    }
}
