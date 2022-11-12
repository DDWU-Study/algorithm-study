package src.com.ddwu.study.eunyoung.programmers._221113;

import java.util.ArrayList;

public class 이진변환반복하기 {
    public static int[] solution(String s) {
      int[] answer = new int[2];
      int num =0;
      int cnt=0;
      int preSLen = 0;
      int forSLen = 0;
      while(true){
          preSLen = s.length();
         s = s.replaceAll("0","");
          forSLen = s.length();
          cnt = (preSLen - forSLen)+cnt;
       //  System.out.println(s);
         s=mkBinary(s);
         num++;
         if(s.equals("1")) break;
        }
        //System.out.println("num"+num);
       // System.out.println("cnt"+cnt);
        answer[0]=num;
        answer[1]=cnt;
        return answer;
    }
    public static String mkBinary(String s) {
        int len =  s.length();
        String anw = "";
     //   System.out.println(anw);
        while(len > 0){
            anw = (len%2) +anw;
            len /=2;
        }
      //  System.out.println("anw"+anw);
        return anw;
    }
    public static void main(String[] args) {
        //  System.out.println("이진변환!");
        String s = "110010101001";
        System.out.println(solution( s));
    }
}
