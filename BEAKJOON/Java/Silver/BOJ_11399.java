package BEAKJOON.Java.Silver;

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int prev= 0;
        int time = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            list.add(sc.nextInt());
        }
        Collections.sort(list);
        for(int i = 0; i < N; i++) {
            time += list.get(i) * (N - i);
        }
        System.out.println(time);
    }
}