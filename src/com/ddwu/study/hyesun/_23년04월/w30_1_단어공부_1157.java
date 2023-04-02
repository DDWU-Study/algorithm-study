package com.ddwu.study.hyesun._23년04월;

import java.util.Arrays;
import java.util.Scanner;

public class w30_1_단어공부_1157 {
    public static void main(String[] args) {
        String word = new Scanner(System.in).nextLine().toLowerCase();

        int len = 'z' - 'a' + 1;
        int[] alphabet = new int[len];
        for (char c : word.toCharArray()) {
            ++alphabet[c - 'a'];
        }

        int answerMax=0, index=0;
        for (int i = 0; i < alphabet.length; i++) {
            if (answerMax < alphabet[i]) {
                answerMax = alphabet[i];
                index = i;
            }
        }
        Arrays.sort(alphabet);
        System.out.println(alphabet[len-1]==alphabet[len-2] ? "?" : (char)('A'+index));
    }



}
