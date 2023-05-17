package BEAKJOON.Java.Gold;

import java.util.*;
import java.io.*;

public class BOJ_10026 {
    static int[][] move = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    static char[][] map;
    public static int[] gcc(int N) {
        boolean[][] visit = new boolean[N][N];
        int count = 0;
        int week_count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visit[i][j]) {
                    bfs(N, visit, i, j, false);
                    count++;
                }
            }
        }
        visit = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visit[i][j]) {
                    bfs(N, visit, i, j, true);
                    week_count++;
                }
            }
        }
        return new int[] {count, week_count};
    }

    private static void bfs(int N, boolean[][] visit, int i, int j, boolean week) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {i, j});
        while(!q.isEmpty()) {
            int[] c = q.poll();
            int y = c[0];
            int x = c[1];

            for(int[] m : move) {
                int ny = y + m[0];
                int nx = x + m[1];
                if(ny >= 0 && ny < N && nx >= 0 && nx < N) {
                    if (!week) {
                        if (!visit[ny][nx] && map[y][x] == map[ny][nx]) {
                            q.offer(new int[]{ny, nx});
                            visit[ny][nx] = true;
                        }
                    } else {
                        if (!visit[ny][nx]) {
                            if (map[y][x] == 'B' && map[ny][nx] == 'B') {
                                q.offer(new int[]{ny, nx});
                                visit[ny][nx] = true;
                            } else if(map[y][x] != 'B' && map[ny][nx] != 'B'){
                                q.offer(new int[]{ny, nx});
                                visit[ny][nx] = true;
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for(int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();
            map[i] = arr;
        }
        int[] result = gcc(N);
        System.out.println(result[0] + " " + result[1]);
    }
}
