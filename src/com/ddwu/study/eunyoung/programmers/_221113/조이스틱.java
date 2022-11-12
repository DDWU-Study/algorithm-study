package src.com.ddwu.study.eunyoung.programmers._221113;

public class 조이스틱 { //그리디 써야하는거 같은데 ,,,기억이 안나요,,

    public static int solution(String name) {
        int answer =0;
        char word;
        int pre = 65;
        final int A = 65,Z=90;
        for (int i=0;i<name.length();i++ ){
            word = name.charAt(i);
            int word1 = word;

            if(Math.abs(word1 - A) >= Math.abs(word1 - Z))
                {  System.out.println("Math.abs(word1 - A)"+Math.abs(word1 - A));
                    System.out.println("Math.abs(word1 - Z)"+Math.abs(word1 - Z));
                    System.out.println("Math.abs(word1 - pre)"+Math.abs(word1 - pre));
                    System.out.println("Math.abs(word1 - A)+1+Math.abs(word1 - Z)"+(Math.abs(word1 - A)+1+Math.abs(word1- Z)));
                    if (Math.abs(word1 - A)>=(Math.abs(word1 - A)+1+Math.abs(word1- Z)) ){
                    answer=answer+(Math.abs(word1 - A)+1+Math.abs(word1 - Z));
                    System.out.println("1word "+word +" ascii "+word1 +"pre"+pre +"answer"+answer);
                }
                   else if( Math.abs(word1 - Z) >= Math.abs(word1 - pre) )
                {answer=answer+Math.abs(word1 - pre);
                    System.out.println("1.5word "+word +" ascii "+word1 +"pre"+pre +"answer"+answer);}

                else {answer=answer+1+Math.abs(word1 - Z);
                    System.out.println("2word "+word +" ascii  "+word1+"pre"+pre +"answer"+answer);}}


            else { if( Math.abs(word1 - A) >= Math.abs(word1 - pre) )
            {answer=answer+Math.abs(word1 - pre);
                System.out.println("3word "+word +" ascii   "+word1+"pre"+pre +"answer"+answer);}
            else {answer=answer+1+Math.abs(word1 - A);
                System.out.println("4word "+word +" ascii    "+word1+"pre"+pre +"answer"+answer);}}

            pre = word1;
            //System.out.println("word"+word +"ascii"+ascii);
        }
        return answer;
    }

    public static void main(String[] args) {
        //  System.out.println("조이스틱!");
        String name = "JEROEN";
       // String name = "JAZ";
        System.out.println(solution( name));
    }
}
