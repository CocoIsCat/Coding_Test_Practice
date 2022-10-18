import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        char[] cArr = s.toCharArray();
        for(char ch : cArr) {
            if(ch == '(') {
                stack.push(ch);
            }
            else {
                if(!stack.isEmpty())
                    stack.pop();
                else
                    return false;
            }
        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    }
}