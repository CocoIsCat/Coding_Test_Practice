import java.util.*;

class Solution {
    boolean solution(String s) {
        int count = 0;
        boolean answer = true;
        s = s.toUpperCase();
        char[] cArr = s.toCharArray();

        for(char ch : cArr) {
            if(ch == 'P') {
                count++;
            }
            else if(ch == 'Y') {
                count--;
            }
        }

        if(count == 0) {
            return true;
        }
        else {
            return false;
        }
    }
}