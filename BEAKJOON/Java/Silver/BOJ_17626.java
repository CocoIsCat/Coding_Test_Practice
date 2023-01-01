package BEAKJOON.Java.Silver;

import java.util.*;

class Main {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        int[] memo = new int[n + 1];
        memo[1] = 1;
        for(int i = 2; i <= n; i++) {
            int a1 = (int)Math.sqrt(i);
            if(i == (int)Math.pow(a1, 2)) {
                memo[i] = 1;
            }
            else {
                int a2 = i - (int) Math.pow(a1, 2);
                while (a1 > 0) {
                    if (memo[a2] != 0) {
                        if(memo[i] == 0)
                            memo[i] = 1 + memo[a2];
                        else
                            memo[i] = Math.min(memo[i], 1 + memo[a2]);
                    }
                    a1--;
                    a2 = i - (int) Math.pow(a1, 2);
                }
            }
        }
        System.out.println(memo[n]);
    }
}