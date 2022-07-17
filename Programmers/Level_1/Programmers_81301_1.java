import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        HashMap<String, String> map1 = new HashMap<>();
        map1.put("zero", "0");
        map1.put("one", "1");
        map1.put("two", "2");
        map1.put("three", "3");
        map1.put("four", "4");
        map1.put("five", "5");
        map1.put("six", "6");
        map1.put("seven", "7");
        map1.put("eight", "8");
        map1.put("nine", "9");

        Iterator<String> i = map1.keySet().iterator();
        while(i.hasNext()) {
            String key = i.next();
            if(s.contains(key)) {
                String value = map1.get(key);
                s = s.replace(key, value);
            }
        }
        answer = Integer.parseInt(s);
        return answer;
    }
}