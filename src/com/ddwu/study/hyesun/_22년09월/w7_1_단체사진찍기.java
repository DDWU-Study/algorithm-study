package com.ddwu.study.hyesun._22년09월;

//https://school.programmers.co.kr/learn/courses/30/lessons/1835
/*
    answer
    - 조건을 입력으로 받았을 때 모든 조건을 만족할 수 있도록 서는 경우의 수
 */
public class w7_1_단체사진찍기 {
    static String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
    static int ansNum = 0;

    static int solution(int n, String[] data) {
        ansNum =0;
        dfs("", new boolean[8], data);
        return ansNum;
    }

    static void dfs(String names, boolean[] isVisited, String[] datas) {
        if (names.length() == 7) {
            if (checkNum(names, datas)) ansNum++;
            return;
        }
        for (int i = 0; i < 8; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                String name = names + friends[i];
                dfs(name, isVisited, datas);
                isVisited[i] = false;
            }
        }
    }

    static boolean checkNum(String names, String[] datas) {
        for (String d : datas) {
            int pos1 = names.indexOf(d.charAt(0));
            int pos2 = names.indexOf(d.charAt(2));
            char op = d.charAt(3);
            int index = d.charAt(4) -'0';
            if (op == '=') {
                if (!(Math.abs(pos1 - pos2) == index+1)) return false;
            } else if (op == '>') {
                if (!(Math.abs(pos1 - pos2) > index+1)) return false;
            } else if (op == '<') {
                if (!(Math.abs(pos1 - pos2) < index+1)) return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(solution(2, new String[]{"N~F=0", "R~T>2"}));
        System.out.println(solution(2, new String[]{"M~C<2", "C~M>1"}));
    }
}
