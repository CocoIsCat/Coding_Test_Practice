package BEAKJOON.Java.Gold;

import java.util.*;
import java.io.*;

class BOJ_16928 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] visit = new int[101];
        Arrays.fill(visit, Integer.MAX_VALUE);
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        for(int j = 0; j < M; j++) {
            st = new StringTokenizer(br.readLine());
            map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visit[1] = 0;
        while(!q.isEmpty()) {
            int current = q.poll();
            while(map.containsKey(current)) {
                current = map.get(current);
            }
            for (int i = 1; i <= 6; i++) {
                int next = current + i;
                if (next <= 100) {
                    if (map.containsKey(next)) {
                        next = map.get(next);
                        if(visit[next] > visit[current] + 1) {
                            q.offer(next);
                            visit[next] = visit[current] + 1;
                        }

                    } else {
                        if(visit[next] > visit[current] + 1) {
                            q.offer(next);
                            visit[next] = visit[current] + 1;
                        }
                    }
                }
            }
        }
        System.out.println(visit[100]);
    }
}

