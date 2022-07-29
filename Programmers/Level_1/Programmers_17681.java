import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for(int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            /*2진수 변환*/
            char[] binary1 = String.format("%0" + n + "d", Long.parseLong(Long.toBinaryString(arr1[i]))).toCharArray();
            char[] binary2 = String.format("%0" + n + "d", Long.parseLong(Long.toBinaryString(arr2[i]))).toCharArray();

            /*i번째 줄 지도 제작*/
            for(int j = 0; j < n; j++) {
                if(binary1[j] == '1' || binary2[j] == '1') {
                    sb.append("#");
                }
                else {
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}