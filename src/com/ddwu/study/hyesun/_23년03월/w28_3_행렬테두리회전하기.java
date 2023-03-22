package com.ddwu.study.hyesun._23년03월;

import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/77485
/*

    참고 : https://settembre.tistory.com/380
    https://velog.io/@ckr3453/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%ED%96%89%EB%A0%AC-%ED%85%8C%EB%91%90%EB%A6%AC-%ED%9A%8C%EC%A0%84%ED%95%98%EA%B8%B0-Java
 */
public class w28_3_행렬테두리회전하기 {

    static int[] solution(int rows, int columns, int[][] queries) {
        int[][] square = initSquare(rows, columns);
        return rotateNums(square, queries);
    }
    static int[] rotateNums(int[][] square, int[][] queries){
        int[] answer = new int[queries.length];
        int minimalsIdx=0;

        for(int[] query : queries){
            int x1 = query[0]-1;
            int y1 = query[1]-1;
            int x2 = query[2]-1;
            int y2 = query[3]-1;
            int firstNum = square[x1][y2];
            int min = firstNum;

            for(int i=y2-1; i>=y1; i--){
                min = Math.min(min, square[x1][i]);
                square[x1][i+1] = square[x1][i];
            }

            for(int i=x1+1; i<=x2; i++){
                min = Math.min(min, square[i][y1]);
                square[i-1][y1] = square[i][y1];
            }

            for(int i=y1+1; i<=y2; i++){
                min = Math.min(min, square[x2][i]);
                square[x2][i-1] = square[x2][i];
            }

            for(int i=x2-1; i>=x1; i--){
                min = Math.min(min, square[i][y2]);
                square[i+1][y2] = square[i][y2];
            }

            square[x1+1][y2] = firstNum;
            answer[minimalsIdx] = min;
            minimalsIdx++;
        }

        return answer;
    }

    static int[][] initSquare(int rows, int columns){
        int[][] square = new int[rows][columns];
        int value = 1;
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                square[i][j] = value;
                value++;
            }
        }

        return square;
    }


    public static void main(String[] args) {
        Arrays.toString(solution(6, 6, new int[][]{{2,2,5,4},{3,3,6,6},{5,1,6,3}}));
        Arrays.toString(solution(6, 6, new int[][]{{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}}));
        Arrays.toString(solution(6, 6, new int[][]{{1,1,100,97}}));
    }

}
