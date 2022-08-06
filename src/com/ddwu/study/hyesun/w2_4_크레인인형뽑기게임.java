package com.ddwu.study.hyesun;

import java.util.Stack;

/*
 같은 모양의 인형 두 개가 바구니에 연속해서 쌓이게 되면 두 인형은 터뜨려지면서 바구니에서 사라지게

  제약조건
    1.  없는 곳에서 크레인을 작동시키는 경우에는 아무런 일도 일어나지 않습니다
    2.  바구니는 모든 인형이 들어갈 수 있을 만큼 충분히 크다

    return
    크레인을 모두 작동시킨 후 터트려져 사라진 인형의 개수
 */
/*
에러
    1. 맨처음 빈스택에서 조회 에러 util.EmptyStackException
 */
public class w2_4_크레인인형뽑기게임 {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int m : moves) {
            int c = m - 1; // 크레인 start 인덱스1
            //탐색
            int r = 0;
            while (r < board.length && board[r][c] == 0) r++; //범위체크를 먼저해야 에러방지
            if (r == board.length) continue; //인형 없음

            //위치 0 으로 바꾸고 스택에 조회
            int ballNum = board[r][c];
            board[r][c] = 0;
            //top과 같다면 사라지게& 답+=2, 다르다며 ㄴ입력
            if (stack.isEmpty() || ballNum != stack.peek()) {
                stack.push(ballNum);
            } else {
                answer += 2;
                stack.pop();
            }
        }//for-each

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}}, new int[]{1, 5, 3, 5, 1, 2, 1, 4}));
    }
}
