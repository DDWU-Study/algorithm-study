package src.com.ddwu.study.eunyoung.programmers._221120;

public class 피보나치수 {
    public static int solution(int n) {
          //  int answer = 0;
            return fibo(n);
        }
    public static  int fibo(int n){
        if(n==0 || n==1) return n;

        return fibo(n-1)+fibo((n-2));
    }
    public static void main (String[] args){
        System.out.println(solution(5));
    }
}
