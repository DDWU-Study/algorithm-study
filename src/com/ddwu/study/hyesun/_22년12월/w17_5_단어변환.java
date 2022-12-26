package com.ddwu.study.hyesun._22년12월;

import java.util.ArrayDeque;
import java.util.Queue;

//https://school.programmers.co.kr/learn/courses/30/lessons/43163
/*

    정답 : 최소 몇 단계의 과정을 거쳐 begin을 target으로 변환
    
    나중에 bfs로도 다시 풀어보기
 */
public class w17_5_단어변환 {
    static boolean[] visited;
    static int answer = 0;

    static int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];

        dfs(begin, target, words, 0);
        return answer;
    }

    static void dfs(String begin, String target, String[] words, int cnt) {
        if (begin.equals(target)) {
            answer = cnt;
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (visited[i]) {
                continue;
            }

            int k = 0;
            for (int j = 0; j < begin.length(); j++) {
                if (begin.charAt(j) == words[i].charAt(j)) {
                    k++;
                }
            }

            if (k == begin.length() - 1) {
                visited[i] = true;
                dfs(words[i], target, words, cnt + 1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
    }
}
