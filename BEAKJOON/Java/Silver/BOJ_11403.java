package BEAKJOON.Java.Silver;

import java.io.*;
import java.util.*;

class Main {
    static int[][] result;
    static Map<Integer, ArrayList<Integer>> gphList = new HashMap<>();

    static void BFS(int i, int N) {
        boolean[] visit = new boolean[N];
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        while (!q.isEmpty()) {
            int me = q.poll();
            ArrayList<Integer> neighbor = gphList.get(me);
            for (int node : neighbor) {
                if(!visit[node]) {
                    q.offer(node);
                    visit[node] = true;
                    result[i][node] = 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        result = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Integer> neighbor = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                if (st.nextToken().equals("1")) {
                    neighbor.add(j);
                }
            }
            gphList.put(i, neighbor);
        }

        for (int i = 0; i < N; i++) {
            BFS(i, N);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(result[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.close();
    }
}
