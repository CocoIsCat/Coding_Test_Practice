import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        double[] arr = new double[N + 1];
        int user = stages.length;  //사람 수
        int[] answer = new int[N];

        for(int i = 1; i <= N; i++) {
            int challenger = 0;

            for(int u : stages) {
                if(u == i) {
                    challenger++;
                }
            }
            arr[i] = (double)challenger/user;
            if(Double.isNaN(arr[i])) {
                arr[i] = 0;
            }
            user -= challenger;
        }

        for(int i = 0; i < N; i++) {
            double max = -1.0;
            for(int j = 1; j <= N; j++) {
                if(arr[j] > max) {
                    max = arr[j];
                    answer[i] = j;
                }
            }
            arr[answer[i]] = -100.0;
        }
        return answer;
    }
}