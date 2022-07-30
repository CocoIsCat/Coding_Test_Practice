import java.util.*;
import java.lang.Math;

class Solution {
    public int solution(String dartResult) {
        int num = 0;
        int index = 1;
        int[] score = new int[4];
        char[] arr = dartResult.toCharArray();

        for(int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            if(Character.isDigit(ch)) {
                if(Character.isDigit(arr[i + 1])) {
                    num = 10;
                    i++;
                }
                else {
                    num = Character.getNumericValue(ch);
                }
            }

            else if(Character.isAlphabetic(ch)) {
                if(ch == 'S') {
                    score[index] = num;
                    index++;
                }
                else if(ch == 'D') {
                    score[index] = (int)Math.pow(num, 2);
                    index++;
                }
                else {
                    score[index] = (int)Math.pow(num, 3);
                    index++;
                }
            }
            else {
                if(ch == '*') {
                    score[index - 1] *= 2;
                    score[index - 2] *= 2;
                }
                else {
                    score[index - 1] *= -1;
                }
            }
        }
        int answer = score[1] + score[2] + score[3];
        return answer;
    }
}