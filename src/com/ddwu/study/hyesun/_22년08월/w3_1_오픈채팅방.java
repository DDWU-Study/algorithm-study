package com.ddwu.study.hyesun._22년08월;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
    Enter id 이름 - 개명했는지 확인 , 출력=님이 들어왔습니다.
    Change id  - 이름맵 갱신
    Leave id 이름 - 미리출력하면 나중에갱신된거 반영안됨, 출력=님이 나갔습니다.

    List<String> → String[]으로 변환
 */
public class w3_1_오픈채팅방 {
    public static String[] solution(String[] record) {

        HashMap<String, String> map = new HashMap<>();
        ArrayList<String[]> al = new ArrayList(record.length);
        for (String r : record) {
            String[] s = r.split(" ");

            String cmd = s[0];
            String id = s[1];
            String inputName ="";
            if(!cmd.equals("Leave"))
                inputName = s[2];

            String name = map.getOrDefault(id, "new");

            if(name.equals("new")) map.put(id, inputName);
            else if (cmd.equals("Change") || cmd.equals("Enter")) {
                map.replace(id, inputName);
            }
            if (cmd.equals("Change")) continue;

            al.add(new String[]{id, cmd.equals("Enter") ? "님이 들어왔습니다." : "님이 나갔습니다."});
        }

        al.trimToSize();
        ArrayList<String> answer = new ArrayList(al.size());
        for (String[] a : al) {
            String id = a[0];
            answer.add(map.get(id) + a[1]);
        }

        return answer.toArray(new String[al.size()]); // 리스트<String> → String[]로 변환
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"})));
    }


}
