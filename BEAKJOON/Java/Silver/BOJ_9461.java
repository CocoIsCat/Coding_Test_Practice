package BEAKJOON.Java.Silver;

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] result = new long[101];
        int T = sc.nextInt();
        result[1] = 1;
        result[2] = 1;
        result[3] = 1;
        result[4] = 2;
        result[5] = 2;
        result[6] = 3;
        result[7] = 4;
        result[8] = 5;
        for (int i = 9; i < 101; i++) {
            result[i] = result[i - 1] + result[i - 5];
        }
        while (T-- > 0) {
            System.out.println(result[sc.nextInt()]);
        }
    }
}
