package com.ddwu.study.hyesun._22년11월;

//https://school.programmers.co.kr/learn/courses/30/lessons/12924
/*
    시간 복잡도 O(n^2)
    투 포인터 O(n)
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
    static int solution_twoPointer(int n) {
        int ansCnt = 1;
        int sum = 0;
        // n까지 포함이므로 범위 (i < n+1)
        for (int start = 1, i = 1; start < n / 2 + 1 && i < n+1; i++) {
            while (sum > n && start < n / 2 + 1) {
                sum -= start++;
        }
            if (sum == n) ansCnt++;
            sum += i;
        }
            return ansCnt;
    }
    public static void main(String args[]) throws Exception {
        System.out.println(solution(15));
        System.out.println("Two Pointer = " + solution_twoPointer(15));
    }

}
