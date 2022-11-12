package src.com.ddwu.study.eunyoung.programmers._221113;

import java.util.ArrayList;
import java.util.Arrays;

public class 햄버거_만들기 {
    public static int solution(int[] ingredient) {
      int answer = 0;
      int cnt =0;
        ArrayList<Integer> list = new ArrayList<>();
       for(int i=0 ; i < ingredient.length ; i++){
           list.add(ingredient[i]);
           System.out.println("ingredient[i]"+ingredient[i]);
           if(i>=4 && ingredient[i]==1 && ingredient[i-1]==3 &&ingredient[i-2]==2&&ingredient[i-3]==1){

               list.remove(cnt);
               list.remove(cnt-1);
               list.remove(cnt-2);
               list.remove(cnt-3);

               answer+=1;
               cnt-=4;
           }
           cnt++;
       }
        return answer;
    }

    public static void main(String[] args) {
      //  System.out.println("햄버거!");
        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        System.out.println(solution( ingredient));
    }
}
