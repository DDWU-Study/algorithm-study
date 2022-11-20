package com.ddwu.study.hyesun._22년11월;

//https://school.programmers.co.kr/learn/courses/30/lessons/12945
/*
    시간 복잡도 O(n^2)
    two pointer 가능 할거 같은데 풀면 추가 할게요
 */
public class w13_3_숫자의표현 {
    static int solution(int n) {
        int answer = 1; // n
        for (int i = 1; i < (n / 2 + 1); i++) {
            int sum = i;

            for (int j = i + 1; ; j++) {
                sum += j;
                if (sum < n) continue;
                if (sum == n) ++answer;
                break; //같거나 초과
            }
        }
        return answer;
    }

    public static void main(String args[]) throws Exception {
        System.out.println(solution(15));
    }

}
