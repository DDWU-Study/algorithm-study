package com.ddwu.study.jieun.week4;

import java.util.ArrayList;

public class 성격_유형_검사하기 {

    public static void main(String[] args) {

        String[] survey1 = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices1 = {5, 3, 2, 7, 5};
        System.out.println("result 1 : " + solution(survey1, choices1));

        String[] survey2 = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices2 = {7, 1, 3};
        System.out.println("result 2 : " + solution(survey2, choices2));
    }

    enum Choice {
        TOTALLY_DISAGREE(3), DISAGREE(2), SLIGHTLY_DISAGREE(1),
        UNKNOWN(0),
        SLIGHTLY_AGREE(1), AGREE(2), TOTALLY_AGREE(3);

        public final int score;

        Choice(int score) {
            this.score = score;
        }

        int getScore() { return score; }
    }

    static class Type {
        String name;
        int score;

        Type() {
            score = 0;
        }

        public void setName(String name) { this.name = name; }
        public void setScore(int score) { this.score += score; }

        public String getName() { return name; }
        public int getScore() { return score; }
    }

    public static String solution(String[] survey, int[] choices) {
        ArrayList<Type> typeList = new ArrayList<>();
        for (int idx = 0; idx < choices.length; idx++) {
            Choice choice = getChoice(choices[idx]);
            // survey 원소 쪼개기, type.name 넣어주기
            Type type = new Type();
            if (choices[idx] <= Choice.UNKNOWN.ordinal()) {
                type.setName(survey[idx].substring(0, 1));
                System.out.println("부정 : " + type.getName());

            } else {
                type.setName(survey[idx].substring(1));
                System.out.println("긍정 : " + type.getName());
            }
            // 점수 넣어주기
            type.setScore(choice.getScore());
            System.out.println(type.getScore());

        }
        String answer = "";
        return answer;
    }

    public void getHighestType (ArrayList<Type> typeList) {
        String[][] type_list = { {"R", "T"}, {"C", "F"}, {"J", "M"}, {"A", "N"} };
        int[][] type_score = { {0, 0}, {0, 0}, {0, 0}, {0, 0} };
    }

    public static Choice getChoice (int choice) {
        switch (choice) {
            case 1:
                return Choice.TOTALLY_DISAGREE;
            case 2:
                return Choice.DISAGREE;
            case 3:
                return Choice.SLIGHTLY_DISAGREE;
            case 4:
                return Choice.UNKNOWN;
            case 5:
                return Choice.SLIGHTLY_AGREE;
            case 6:
                return Choice.AGREE;
            case 7:
                return Choice.TOTALLY_AGREE;
            default:
                return Choice.UNKNOWN;
        }
    }

}
