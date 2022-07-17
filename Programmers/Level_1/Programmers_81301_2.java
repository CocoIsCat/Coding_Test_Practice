import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int i = 0; i < 10; i++) {
            String alp = arr[i];
            s = s.replace(alp, String.valueOf(i));
        }
        answer = Integer.parseInt(s);
        return answer;
    }
}