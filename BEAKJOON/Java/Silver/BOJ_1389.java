package BEAKJOON.Java.Silver;

import java.util.*;
import java.io.*;

class Main {

    static int minSum = Integer.MAX_VALUE;
    static int result = 5001;
    static ArrayList<ArrayList<Integer>> gph = new ArrayList<>();
    static int N;
    static void BFS(int node) {
        Queue<Integer> q = new LinkedList<>();
        int sum = 0;
        int[] visit = new int[5001];
        q.offer(node);
        visit[node] = 1;

        while(!q.isEmpty()) {
            int base = q.poll();
            ArrayList<Integer> neighbor = gph.get(base);
            for(int i : neighbor) {
                if(visit[i] == 0) {
                    q.offer(i);
                    if(base == node)
                        visit[i] = visit[base];
                    else
                        visit[i] = visit[base] + 1;
                }
            }
        }
        for(int i = 1; i <= N; i++) {
            sum += visit[i];
        }

        if(sum < minSum) {
            minSum = sum;
            result = node;
        }
        else if (sum == minSum)
            result = result < node ? result : node;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= N; i++) {
            gph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            gph.get(A).add(B);
            gph.get(B).add(A);
        }

        for(int i = 1; i <= N; i++) {
            BFS(i);
        }

        System.out.println(result);
    }
}
