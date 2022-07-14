package Programmers.Level_1;

import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {

        HashMap<String, HashSet> map = new HashMap();
        HashMap<String, Integer> resultMap = new HashMap();
        int elementNum = id_list.length;
        int reportNum = report.length;
        int[] answer = new int[elementNum];

        for(int i = 0; i < elementNum; i++) {
            map.put(id_list[i], new HashSet());
            resultMap.put(id_list[i], 0);
        }

        for(int i = 0; i < reportNum; i++) {
            String[] temp = report[i].split(" ");
            if(map.containsKey(temp[1])) {
                map.get(temp[1]).add(temp[0]);
            }
        }

        Iterator<String> keys = map.keySet().iterator();

        while(keys.hasNext()) {
            String key = keys.next();
            HashSet tempSet = map.get(key);
            int setSize = tempSet.size();
            Iterator<String> ids = tempSet.iterator();

            if(setSize >= k) {
                while(ids.hasNext()) {
                    String id = ids.next();
                    int num = resultMap.get(id);
                    num = num + 1;
                    resultMap.put(id, num);
                }
            }
        }

        for(int i = 0; i < elementNum; i++) {
            answer[i] = resultMap.get(id_list[i]);
        }

        return answer;
    }
}