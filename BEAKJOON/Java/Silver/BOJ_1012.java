package BEAKJOON.Java.Silver;

import java.util.*;
import java.io.*;

class Main {
    static boolean[][] map;
    static boolean[][] visit;
    static Queue<int[]> q;

    static void BFS() {
        while (!q.isEmpty()) {
            int[] value = q.poll();
            int x = value[0];
            int y = value[1];
            if (x >= 0 && y >= 0) {
                if (!visit[x][y] && map[x][y]) {
                    q.offer(new int[]{x, y - 1});
                    q.offer(new int[]{x, y + 1});
                    q.offer(new int[]{x - 1, y});
                    q.offer(new int[]{x + 1, y});
                }
                visit[x][y] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] sArr = br.readLine().split(" ");
            int M = Integer.parseInt(sArr[0]);
            int N = Integer.parseInt(sArr[1]);
            int K = Integer.parseInt(sArr[2]);
            int count = 0;
            map = new boolean[51][51];
            visit = new boolean[51][51];
            q = new LinkedList<>();
            while (K-- > 0) {
                String[] arr = br.readLine().split(" ");
                map[Integer.parseInt(arr[0])][Integer.parseInt(arr[1])] = true;
            }
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visit[i][j] && map[i][j]) {
                        count++;
                        q.add(new int[]{i, j});
                        BFS();
                    }
                }
            }
            System.out.println(count);
        }
    }
}