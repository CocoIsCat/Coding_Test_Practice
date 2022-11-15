package BEAKJOON.Java.Silver;

import java.util.*;

class Main {
    static List<List<Integer>> listGph = new ArrayList<>();
    static boolean[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();

        check = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            listGph.add(new ArrayList<>());
        }
        while (M-- > 0) {
            int S = sc.nextInt();
            int E = sc.nextInt();

            listGph.get(S).add(E);
            listGph.get(E).add(S);
        }

        listDFS(V);
        check = new boolean[N + 1];
        System.out.println();
        listBFS(V);
    }

    static void listDFS(int s) {
        if (!check[s]) {
            check[s] = true;
            System.out.printf("%d ", s);
            for (int i = 0; i < check.length; i++) {
                if (listGph.get(s).contains(i) && !check[i]) {
                    listDFS(i);
                }
            }
        }
    }

    static void listBFS(int s) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        check[s] = true;
        while (!q.isEmpty()) {
            int n = q.poll();
            System.out.printf("%d ", n);
            for (int i = 0; i < check.length; i++) {
                if (listGph.get(n).contains(i) && !check[i]) {
                    q.offer(i);
                    check[i] = true;
                }
            }
        }
    }
}