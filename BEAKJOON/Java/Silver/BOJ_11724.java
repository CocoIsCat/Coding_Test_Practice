package BEAKJOON.Java.Silver;

import java.util.*;
import java.io.*;

class Main {
    static Queue<Integer> q = new LinkedList<>();
    static List<int[]> edges = new ArrayList<>();
    static List<List<Integer>> nodes = new ArrayList<>();
    static boolean[] visit = new boolean[1001];

    static void BFS() {
        while(!q.isEmpty()) {
            int s = q.poll();
            if(!visit[s]) {
                visit[s] = true;
                List<Integer> l = nodes.get(s);
                for(int i : l) {
                    q.offer(i);
                }
            }
        }
    }

    public static void main(String[ ] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count = 0;
        for(int i = 0; i <= N; i++) {
            nodes.add(new ArrayList<>());
        }

        while(M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());
            edges.add(new int[] {i1, i2});
            nodes.get(i1).add(i2);
            nodes.get(i2).add(i1);
        }

        for(int i = 1; i <= N; i++) {
            if(!visit[i]) {
                q.offer(i);
                BFS();
                count++;
            }
        }

        System.out.println(count);
    }
}