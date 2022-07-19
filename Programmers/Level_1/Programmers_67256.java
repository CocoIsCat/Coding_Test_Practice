import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int[] posi = {10, 12};
        for(int num : numbers) {
            if(num == 0) {
                num = 11;
            }
            if(num % 3 == 1) {
                posi[0] = num;
                answer.append('L');
            }
            else if (num % 3 == 0) {
                posi[1] = num;
                answer.append('R');
            }
            else if(num % 3 == 2){
                int dst[] = new int[2];
                int idx;
                for(int i = 0; i < 2; i++) {
                    dst[i] = Math.abs(num - posi[i]);
                    if(dst[i] == 0) {
                        dst[i] = 0;
                    }
                    else if(dst[i] == 1 || dst[i] == 3) {
                        dst[i] = 1;
                    }
                    else if (dst[i] == 2 || dst[i] == 4 || dst[i] == 6) {
                        dst[i] = 2;
                    }
                    else if (dst[i] == 5 || dst[i] == 7 || dst[i] == 9) {
                        dst[i] = 3;
                    }
                    else {
                        dst[i] = 4;
                    }
                }
                if(dst[0] < dst[1]) {
                    posi[0] = num;
                    answer.append('L');
                }
                else if (dst[0] > dst[1]) {
                    posi[1] = num;
                    answer.append('R');
                }
                else {
                    if(hand.equals("left")) {
                        posi[0] = num;
                        answer.append('L');
                    }
                    else {
                        posi[1] = num;
                        answer.append('R');
                    }
                }
            }
        }
        return String.valueOf(answer);
    }
}