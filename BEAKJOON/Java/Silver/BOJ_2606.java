package BEAKJOON.Java.Silver;

import java.util.*;

class Main {
    static Queue<Integer> q = new LinkedList<>();
    static List<ArrayList<Integer>> gphList = new ArrayList<>();
    static boolean[] visit = new boolean[101];
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int T = sc.nextInt();
        while(N-- >= 0) {
            gphList.add(new ArrayList<Integer>());
        }

        while(T-- > 0) {
            int S = sc.nextInt();
            int E = sc.nextInt();
            gphList.get(S).add(E);
            gphList.get(E).add(S);
        }
        q.offer(1);
        while(!q.isEmpty()) {
            BFS(q.poll());
        }
        System.out.println(count);
    }
    static void BFS(int i) {
        if(!visit[i]) {
            visit[i] = true;
            for(int j : gphList.get(i)) {
                if(!visit[j]) {
                    q.offer(j);
                    count++;
                    BFS(q.poll());
                }
            }
        }
    }
}
