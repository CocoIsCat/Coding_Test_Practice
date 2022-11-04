package BEAKJOON.Java.Bronze;

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int N = sc.nextInt();
            int S = sc.nextInt();

            System.out.println(S / (N + 1));
        }
    }
}
