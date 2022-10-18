class Solution {
    public int solution(int n) {
        int answer = 0;
        int i = 1;
        int j = 0;
        int plus = 0;
        while(j < n) {
            for(int k = 1; k <= n / i; k++) {
                int tmp = (i * k) + j;
                if(tmp > n) {
                    i++;
                    j += ++plus;
                    break;
                }
                else {
                    if(tmp == n) {
                        answer++;
                        i++;
                        j += ++plus;
                        break;
                    }
                }
            }
        }
        return answer;
    }
}