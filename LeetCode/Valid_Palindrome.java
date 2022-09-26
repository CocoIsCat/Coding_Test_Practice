package LeetCode;

import java.util.*;

class Solution {
    public boolean isPalindrome(String s) {
        boolean result = true;
        StringBuilder sb = new StringBuilder();
        char[] cArr = s.toCharArray();
        for(char ch : cArr) {
            if(Character.isAlphabetic(ch) || Character.isDigit(ch)) {
                ch = Character.toLowerCase(ch);
                sb.append(String.valueOf(ch));
            }
        }
        String str = sb.toString();
        String revStr = sb.reverse().toString();
        if(str.equals(revStr)) {
            return true;
        }
        else if(!str.equals(revStr)) {
            return false;
        }
        return result;
    }
}
