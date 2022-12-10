package BEAKJOON.Java.Silver;

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int index = N - 1;
        int count = 0;
        int[] money = new int[N];
        for(int i = 0; i < N; i++) {
            money[i] = sc.nextInt();
        }
        while(K != 0) {
            if(money[index] <= K) {
                int cnt = K / money[index];
                K -= money[index] * cnt;
                count += cnt;
                index--;
            }
            else
                index--;
        }
        System.out.println(count);
    }
}