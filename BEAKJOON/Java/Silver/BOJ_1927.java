package BEAKJOON.Java.Silver;

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> pq = new PriorityQueue<>();
        int N = sc.nextInt();
        while(N-- > 0) {
            int x = sc.nextInt();
            if(x == 0) {
                if (pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll());
                }
            }
            else
                pq.offer(x);
        }
    }
}