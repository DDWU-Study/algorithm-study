package src.com.ddwu.study.eunyoung.programmers._221120;

public class _2016년 {
    public static String solution(int a, int b) {
        String answer = "";
        int start = 5; //1월1일 금요일
        //각 월에 맞는 일자
        int[] month = {31,29,31,30,31,30,31,31,30,31,30,31} ;
        String[] day = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
       // int allDays= month[a-1];
        int torf =0;

        for (int i =0 ; i<a;i++){
         //   System.out.print("----");
          //  System.out.println((i+1)+"월");
            for (int j =0 ; j< month[i];j++){
                if(start >6){start %= 7;} //System.out.print(day[start]);
                if(i==a-1 && j==b-1) { torf = 1; break;}
                start++;
            }
            System.out.println("");
           if(torf==1){ answer = day[start];  break;}
        }
        return answer;
    }

    public static void main(String[] args) {
        //  System.out.println("2016!");
        System.out.println(solution(5,24));
    }
}
