package com.ddwu.study.hyesun._23년1월;


//https://school.programmers.co.kr/learn/courses/30/lessons/43165
/*
    dfs라기보단 모든경우의수(brute force)가깝다고 생각
        원소값을 미리정렬 X -> 어떤원소가 나오는지 알수없어서 끝까지 보고 판다 -> 모든경우의 수
    만약,원소값을 미리정렬 O -> 어떤원소가 나오는지 알수있음 -> 중간 가지치기 -> Backtracking

 */
public class w20_1_타겟넘버 {
    static int solution(int[] numbers, int target) {
        return recurse(0, 0, numbers, target);
    }

    private static int recurse(int sum, int i, int[] numbers, int target) {
        if(i == numbers.length) {
            return (sum == target) ? 1 : 0;
        }

        int retCnt = 0;
        retCnt += recurse(sum + numbers[i], i + 1, numbers, target);
        retCnt += recurse(sum - numbers[i], i + 1, numbers, target);
        return retCnt;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(solution(new int[]{4, 1, 2, 1}, 4));

    }
}