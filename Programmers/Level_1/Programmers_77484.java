package Programmers.Level_1;

import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {0, 0};
        int matchNum = 0;
        int zeroCnt = 0;
        for(int num1 : lottos) {
            for(int num2 : win_nums) {
                if(num2 == num1) {
                    matchNum++;
                }
            }
            if(num1 == 0) {
                zeroCnt++;
            }
        }
        answer[0] = 7 - (matchNum + zeroCnt);
        answer[1] = 7 - matchNum;

        if(answer[0] == 7) {
            answer[0] = 6;
        }

        if(answer[1] == 7) {
            answer[1] = 6;
        }

        return answer;
    }
}
