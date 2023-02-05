package programmers.level2;

import org.junit.Assert;
import org.junit.Test;

public class 멀리_뛰기 {

    @Test
    public void main() {
        Assert.assertEquals(5, solution(4));
        Assert.assertEquals(3, solution(3));
        Assert.assertEquals(13, solution(6));
        Assert.assertEquals(8, solution(5));

    }

    // 같은 것이 있는 순열 문제
    // 근데 알고보니 피보나치 변형,,,, (DP로 풀기)
    long[] memo;
    public long solution(int n) {
        memo = new long[n + 1];
        for(int i = 0; i <= n; i++) {
            if(i <= 2) {
                // 기본 피보나치와는 조금 다르게 0은 0, 1은 1, 2는 2임. 이후는 피보나치 규칙과 동일.
                memo[i] = i;
            } else {
                memo[i] = (memo[i - 1] + memo[i - 2]) % 1234567;
            }
        }
        return memo[n];
    }
}
