package com.ddwu.study.hyesun._22년10월;
//https://school.programmers.co.kr/learn/courses/30/lessons/42862

public class w9_3_체육복 {
    static int solution(int n, int[] lost, int[] reserve) {
        int[] status = new int[n + 1]; //읽어버리면 -1, 여벌은 1
        //함정 lost == reserve 번호 제거하기
        for (int i : lost)    status[i]  = -1;
        for (int i : reserve) status[i]  += 1;

        for (int i = 1; i < status.length; i++) {
            if (status[i] == 0) continue;
            if (status[i] <0) {
                if(status[i-1] ==1){
                    status[i-1] =0;
                    ++status[i];
                }else if(i+1<n+1 && status[i+1] ==1){
                    status[i+1] =0;
                    ++status[i];
                }
            }

        }

        //체육복 있는 학생의 수 (-1는 읽어버렸으므로 참가불가)
        int lostNum = 0;
        for (int v : status) {
            if(v == -1) lostNum++;
        }
        return n - lostNum;
    }

    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
        System.out.println(solution(5, new int[]{2, 4}, new int[]{3}));
        System.out.println(solution(3, new int[]{3}, new int[]{1}));
    }
}
