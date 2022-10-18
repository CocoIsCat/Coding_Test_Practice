package BEAKJOON.Java.Silver;

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] call0 = new int[41];
        int[] call1 = new int[41];
        call0[0] = 1;
        call1[1] = 1;
        for(int i = 2; i <= 40; i++) {
            call0[i] = call0[i - 1] + call0[i - 2];
            call1[i] = call1[i - 2] + call1[i - 1];
        }
        for(int i = 0; i < T; i++) {
            int num = sc.nextInt();
            System.out.println(call0[num] + " " + call1[num]);
        }
    }
}