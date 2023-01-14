package BEAKJOON.Java.Silver;

import java.util.*;
import java.io.*;

class Main {
    static char[][] map;
    static ArrayList<Integer> result = new ArrayList<>();
    static boolean[][] visit;
    static Queue<int[]> q;

    static void BFS() {
        int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int count = 0;
        while(!q.isEmpty()) {
            int[] axis = q.poll();
            count++;
            for(int[] m : move) {
                int x = axis[0] + m[0];
                int y = axis[1] + m[1];
                if(map[x][y] == '1' && !visit[x][y]) {
                    q.offer(new int[] {x, y});
                    visit[x][y] = true;
                }
            }
        }
        result.add(count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new char[N + 2][N + 2];
        visit = new boolean[N + 2][N + 2];

        for(int i = 1; i <= N; i++) {
            char[] line = br.readLine().toCharArray();
            for(int j = 1; j <= N; j++) {
                map[i][j] = line[j - 1];
            }
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(map[i][j] == '1' && !visit[i][j]) {
                    q = new LinkedList<>();
                    q.offer(new int[] {i, j});
                    visit[i][j] = true;
                    BFS();
                }
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        for(int i : result) {
            System.out.println(i);
        }
    }
}
