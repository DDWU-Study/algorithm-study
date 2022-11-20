package src.com.ddwu.study.eunyoung.programmers._221120;

public class 숫자의표현 {
    public static int solution(int n){
        int answer = 0;
        int total =0 ;
        for(int i=1 ; i<=n;i++){
            for(int j =i;j<=n;j++){
                total+=j;
             //   System.out.println(j +"dd"+total);
                if(total ==n) { answer++; }
                else if (total > n) {
                    break;
                }
            }
            total = 0;

        }
        return answer;
    }

    public static void main (String[] args){
        System.out.println(solution(15));
    }
}
