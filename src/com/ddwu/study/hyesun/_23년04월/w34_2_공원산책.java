package com.ddwu.study.hyesun._23년04월;

import java.util.Arrays;
import java.util.HashMap;

//https://school.programmers.co.kr/learn/courses/30/lessons/172928
/*

    정답 return
     로봇 강아지가 모든 명령을 수행 후 놓인 위치를 [세로 방향 좌표, 가로 방향 좌표]  = (r,c)

     조건
     - 명령벼로 미리 실행하고 범위, 장애물괌 만나면 조건무시하고 다음명령 실행

     헷갈린부분
     - (X) 순간이동 ( 기존좌표 + 방향 *이동칸)
     - (O) 한칸씩 지나감

*/
public class w34_2_공원산책 {


    static int[] solution(String[] park, String[] routes) {
        int hSize = park.length, wSize = park[0].length();

        char[][] matrix = new char[hSize][wSize];
        int r = 0, c = 0; //시작위치
        for (int i = 0; i < park.length; i++) {
            if (park[i].contains("S")) {
                r = i;
                c = park[i].indexOf("S");
            }
            matrix[i] = park[i].toCharArray();

        }

        //문자열 -> 방향설정 directionMap
        HashMap<String, int[]> directionMap = new HashMap<>();
        directionMap.put("N", new int[]{-1, 0});
        directionMap.put("S", new int[]{1, 0});
        directionMap.put("W", new int[]{0, -1});
        directionMap.put("E", new int[]{0, 1});

        //명령
        loop:
        for (String route : routes) {
            String[] s = route.split(" ");
            int[] dir = directionMap.get(s[0]);
            int step = Integer.parseInt(s[1]);

//            int tmpR = r + dir[0]*step, tmpC = c + dir[1]*step;
            int tmpR = r, tmpC = c;

            while (step-- > 0) {
                tmpR += dir[0];
                tmpC += dir[1];
                if (tmpR < 0 || tmpR >= hSize || tmpC < 0 || tmpC >= wSize) continue loop;
                if (matrix[tmpR][tmpC] == 'X') continue loop;

            }
            r = tmpR;
            c = tmpC;
        }
        return new int[]{r, c};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"SOO", "OOO", "OOO"}, new String[]{"E 2", "S 2", "W 1"})));
        System.out.println(Arrays.toString(solution(new String[]{"SOO", "OXX", "OOO"}, new String[]{"E 2", "S 2", "W 1"})));
        System.out.println(Arrays.toString(solution(new String[]{"OSO", "OOO", "OXO", "OOO"}, new String[]{"E 2", "S 3", "W 1"})));
    }


}