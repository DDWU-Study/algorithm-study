package com.ddwu.study.hyesun._23년04월;

import java.util.Scanner;
import java.util.Stack;

// scanner로 입력할때 앞에 공백이 끼는문제
public class w30_2_에디터_1406 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

/*
        int cursor = str.length() -1;
        int cursor = str.length();
        String answerString = "";
*/
        StringBuilder sbd = new StringBuilder(str);

        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        String string = sc.nextLine();
        int m = Integer.parseInt(sc.nextLine());

        for (int i=0;i<string.length();i++) {
            leftStack.push(string.charAt(i));
        }

        for (int i=0;i<m;i++) {
            String cmd = sc.nextLine();
            char command = cmd.charAt(0);

            switch (command) {
                case 'P':
                    leftStack.push(cmd.charAt(2));
                    break;
                case 'B':
                    if (!leftStack.isEmpty()) leftStack.pop();
                    break;
                case 'L':
                    if(!leftStack.isEmpty()) rightStack.push(leftStack.pop());
                    break;
                case 'D':
                    if (!rightStack.empty()) leftStack.push(rightStack.pop());
                    break;
                default: break;
            }
        }
        while(!leftStack.empty()) {
            rightStack.push(leftStack.pop());
        }
        while (!rightStack.empty()) {
            sbd.append(rightStack.pop());
        }
        System.out.println(sbd);
    }
}
