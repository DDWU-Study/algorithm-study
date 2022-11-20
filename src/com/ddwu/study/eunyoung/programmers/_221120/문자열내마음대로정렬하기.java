package src.com.ddwu.study.eunyoung.programmers._221120;

import java.util.ArrayList;
import java.util.Comparator;

public class 문자열내마음대로정렬하기 {
    public static String[] solution(String[] strings, int n) {
        int len = strings.length;
        String[] answer = new String[len];

        ArrayList<String> word = new ArrayList<>();

        for ( int i=0 ; i<len;i++){
            word.add(strings[i].substring(n,n+1)+strings[i]);

        }word.sort(Comparator.naturalOrder());
        for ( int i=0 ; i<len;i++){
            answer[i] = word.get(i).substring(1, word.get(i).length());
        }
        return answer;
    }
    public static void main(String[] args) {
        //  System.out.println("문자열내마음대로정렬하기!");
        String[] strings = {"sun", "bed", "car"};
        System.out.println(solution(strings,1));
    }
}
