package src.com.ddwu.study.eunyoung.programmers._221113;

import java.util.ArrayList;
import java.util.Arrays;

public class 햄버거_만들기 {
    public static int solution(int[] ingredient) {
        int answer = 0;
        int start = 1;
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer ingre : ingredient){
            list.add(ingre);
        }

        System.out.println(list);
        return answer;
    }
    public static void main(String[] args) {
        System.out.println("햄버거!");
        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        System.out.println(solution( ingredient));
    }
}
