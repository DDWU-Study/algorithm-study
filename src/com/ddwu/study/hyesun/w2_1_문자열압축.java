package com.ddwu.study.hyesun;

public class w2_1_문자열압축 {
    public static int solution(String str) {
        String ans = "", tmp ="", x;
        int minLength=Integer.MAX_VALUE, strLength=str.length();

        if(str.length()==1) return 1;

        for(int group=1; group<=strLength/2; group++)
        {
            boolean flag=false;//압축이 1번도 일어나지않으면 false - 압축,크기비교 건너뛰기(continue)
            int cnt=1;
            x = str.substring(0, group);//맨처음묶음
            int i= group; //두번재묶음 : 인덱스로나타낸다  이유 : 객체1개로 비교하게만든다(1번째인덱스로 2개만드는것보다 간단)
            for(   ;(i-1)+group<str.length(); i += group)
            {
                if(x.contentEquals(str.substring(i, i+group))) {//contentEquals?
                    cnt++;
                    flag=true;
                    tmp = x.substring(0);
                }else if(flag) {//앞부분까지는 압축
                    ans = ans.concat(cnt + tmp);
                    cnt=1; tmp=null;
                    flag=false;
                    x = str.substring(i, i+group);
                }else{//처음부터 다름
                    ans = ans.concat(x);
                    x = str.substring(i, i+group);
                }

            }
            if(cnt != 1)
                ans = ans.concat(cnt+tmp);
            else
                ans = ans.concat(x);

            ans=ans.concat(str.substring(i));

            minLength = Math.min(minLength, ans.length());
            ans = new String();
        }
        return minLength;
    }
}
