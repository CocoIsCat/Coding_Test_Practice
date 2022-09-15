import java.util.*;
import java.lang.*;

class Solution {

    /*에라스토테네스의 채로 소수 판별*/
    public boolean isPrime(int num) {
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int solution(int[] nums) {
        int len = nums.length;
        int count = 0;

        for(int i = 0; i < len; i++) {
            for(int j = i + 1; j < len; j++) {
                for(int k = j + 1; k < len; k++) {
                    int tmp = nums[i] + nums[j] + nums[k];
                    if(isPrime(tmp)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}