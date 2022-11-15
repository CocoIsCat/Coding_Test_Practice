package BEAKJOON.Java.Silver;

import java.util.*;

class Main {
    static boolean[] check;
    static boolean[][] matGph;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();
        check = new boolean[N + 1];
        matGph = new boolean[N + 1][N + 1];

        for(int i = 0; i < M; i++) {
            int S = sc.nextInt();
            int E = sc.nextInt();

            matGph[S][E] = true;
            matGph[E][S] = true;
        }

        matDFS(V);
        System.out.println();
        check = new boolean[N + 1];
        matBFS(V);
    }

    static void matDFS(int s) {
        if(!check[s]) {
            check[s] = true;
            System.out.printf("%d ", s);
            for (int i = 0; i < check.length; i++) {
                if (matGph[s][i] && !check[i]) {
                    matDFS(i);
                }
            }
        }
    }

    static void matBFS(int s) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        System.out.printf("%d ", s);
        check[s] = true;
        while(!q.isEmpty()) {
            int num = q.poll();
            for(int i = 0; i < check.length; i++) {
                if(matGph[num][i] && !check[i]) {
                    check[i] = true;
                    System.out.printf("%d ", i);
                    q.offer(i);
                }
            }
        }
    }
}