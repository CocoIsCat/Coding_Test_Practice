import java.util.*;
import java.lang.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);

        /*점수 계산*/
        for(int i = 0; i < survey.length; i++) {
            char[] ch = survey[i].toCharArray();
            int score = choices[i];
            if(score > 4) {
                int num = map.get(ch[1]) + (score - 4);
                map.replace(ch[1], num);
            }
            else {
                int num = map.get(ch[0]) + Math.abs(score - 4);
                map.replace(ch[0], num);
            }
        }

        /*출력값 만들기*/
        if(map.get('R') >= map.get('T')) {
            sb.append("R");
        }
        else {
            sb.append("T");
        }

        if(map.get('C') >= map.get('F')) {
            sb.append("C");
        }
        else {
            sb.append("F");
        }

        if(map.get('J') >= map.get('M')) {
            sb.append("J");
        }
        else {
            sb.append("M");
        }

        if(map.get('A') >= map.get('N')) {
            sb.append("A");
        }
        else {
            sb.append("N");
        }

        return sb.toString();
    }
}