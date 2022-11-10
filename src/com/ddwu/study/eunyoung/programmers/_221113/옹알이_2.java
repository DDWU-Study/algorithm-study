package src.com.ddwu.study.eunyoung.programmers._221113;

public class 옹알이_2 {
    static int  solution(String[] babbling) {
        int answer = 0;
        String check = "1";
        int k;
        String[] word = {"aya", "ye", "woo", "ma" };
        String[] noword = {"ayaaya", "yeye", "woowoo", "mama" };
    //    System.out.println("solution 들어옴" );
        for (int i = 0 ; i< babbling.length;i++) {

           // System.out.println(babbling[i] );
            for (int j = 0 ; j< word.length;j++) {
              //  System.out.println(word[j] );
                babbling[i]=babbling[i].replaceAll(noword[j],"1");
                babbling[i]=babbling[i].replaceAll(word[j],"0");
              //  System.out.println("--babbling[i]"+babbling[i] );
            }
            for (k = 0 ; k< babbling[i].length() ;k++) {
              //  System.out.println("k "+k );
                if( !babbling[i].substring(k,k+1).equals("0")) break;
              //  System.out.println("k "+k );
            }
            //System.out.println("babbling[i]"+babbling[i] );
            //System.out.println("check"+check );
            if( k==babbling[i].length()) {

                answer++;
            }

        }
        return answer;

    }
    public static void main(String[] args) {
        System.out.println("옹알이!");
        String[] babbling = {"aya", "yee", "u", "maa"};
        System.out.println(solution( babbling));
    }
}
