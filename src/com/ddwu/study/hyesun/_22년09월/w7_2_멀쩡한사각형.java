package com.ddwu.study.hyesun._22년09월;

//https://school.programmers.co.kr/learn/courses/30/lessons/62048

public class w7_2_멀쩡한사각형 {
    public static long solution(int w, int h) {
        long biggest= (w>h) ? h : w ;
        for (; biggest > 0; biggest--)
            if(w % biggest ==0 && h % biggest ==0)
                break;
        return w*h - (w + h - biggest);
    }
    public static void main(String[] args) {
        System.out.println(solution(8, 12));
    }
}
