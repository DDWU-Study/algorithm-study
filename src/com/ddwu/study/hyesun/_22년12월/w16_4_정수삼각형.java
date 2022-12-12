package com.ddwu.study.hyesun._22년12월;

//https://school.programmers.co.kr/learn/courses/30/lessons/12982
public class w16_4_정수삼각형 {
    static int solution(int[][] triangle) {
        int size = triangle.length;
        if(size==1) return triangle[0][0];

        for (int i = 1; i < size; i++) {
            //열 개수 = (i+1)
            triangle[i][0] += triangle[i-1][0]; //맨앞
            triangle[i][i] += triangle[i-1][i-1]; //맨뒤 (좌표동일)
            for (int j = 1; j < i; j++)
                triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
        }


        //마지막을 최댓값 구하기
        int answer = triangle[size-1][0];
        for (int n : triangle[size - 1])
            answer = Math.max(answer, n);
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }
}
