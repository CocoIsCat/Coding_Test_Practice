package Programmers.Level_1;

import java.util.*;

class Solution {
    public String a(String str) {
        if(str.length() > 0) {
            if(str.charAt(0) == '.') { //4단계
                str = str.substring(1);
            }
            if(str.length() > 0) {
                if(str.charAt(str.length() - 1) == '.') {
                    if(str.length() == 1) {
                        str = str.substring(0, str.length());
                    }
                    else {
                        str = str.substring(0, str.length() - 1);
                    }
                }
            }
        }
        return str;
    }

    public String solution(String new_id) {
        Solution s = new Solution();

        String str = new_id.toLowerCase();  //1단계

        for(char ch : str.toCharArray()) {  //2단계
            if(ch == '_' || ch == '-' || ch == '.') {
                continue;
            }
            if(ch >= 97 && ch <= 122) {
                continue;
            }
            if(ch >= 48 && ch <= 57) {
                continue;
            }
            str = str.replace(String.valueOf(ch), "");
        }

        while(str.contains("...") || str.contains("..")) {
            str = str.replace("...", "."); //3단계
            str = str.replace("..", ".");
        }

        str = s.a(str); //4단계

        if(str.length() == 0) {   //5단계
            str = "a";
        }

        if(str.length() > 15) {   //6단계
            str = str.substring(0, 15);
            str = s.a(str); //4단계 반복
        }

        if(str.length() < 3) {  //7단계
            while(str.length() < 3) {
                str = str.concat(String.valueOf(str.charAt(str.length() - 1)));
            }
        }
        String answer = str;
        return answer;
    }
}
