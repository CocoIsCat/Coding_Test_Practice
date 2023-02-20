package Programmers.Level_1;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int goalIndex = 0;
        int oneIndex = 0;
        int twoIndex = 0;

        for(String str : goal) {
            if(str.equals(cards1[oneIndex])) {
                if(oneIndex + 1 < cards1.length) {
                    oneIndex++;
                } else {
                }
            }
            else if (str.equals(cards2[twoIndex])){
                if(twoIndex + 1 < cards2.length) {
                    twoIndex++;
                } else {
                }
            }
            else {
                return "No";
            }
        }
        return "Yes";
    }
}
