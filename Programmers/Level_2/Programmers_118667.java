import java.util.*;

class Solution {

    public boolean equal(long sum1, long sum2) {
        return sum1 == sum2;
    }

    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        int size = queue1.length;
        long sum1 = 0;
        long sum2 = 0;
        int count = 0;

        for(int i = 0; i < size; i++) {
            int tmp1 = queue1[i];
            int tmp2 = queue2[i];
            sum1 += tmp1;
            sum2 += tmp2;
            q1.offer(tmp1);
            q2.offer(tmp2);
        }
        if(equal(sum1, sum2)) {
            return 0;
        }
        while(count < 3*size) {
            if (sum1 > sum2) {
                int tmp = q1.poll();
                q2.offer(tmp);
                sum1 -= tmp;
                sum2 += tmp;
                count++;
                if (equal(sum1, sum2)) {
                    return count;
                }
            } else {
                int tmp = q2.poll();
                q1.offer(tmp);
                sum1 += tmp;
                sum2 -= tmp;
                count++;
                if (equal(sum1, sum2)) {
                    return count;
                }
            }
        }
        return -1;
    }
}