package BEAKJOON.Java.Silver;

import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static char[][] map;
    static Queue<int[]> q = new LinkedList<>();
    static int[][] visit;
    static void search() {
        int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        while(!q.isEmpty()) {
            int[] axis = q.poll();
            if(axis[0] == N && axis[1] == M) {
                return;
            }
            for(int i = 0; i < 4; i++) {
                int axis_x = axis[0] + move[i][0];
                int axis_y = axis[1] + move[i][1];
                if (axis_x == N && axis_y == M) {
                    visit[axis_x][axis_y] = visit[axis[0]][axis[1]] + 1;
                    return;
                }
                if(map[axis_x][axis_y] == '1') {
                    if(visit[axis_x][axis_y] > visit[axis[0]][axis[1]] + 1) {
                        q.offer(new int[] {axis_x, axis_y});
                        visit[axis_x][axis_y] = visit[axis[0]][axis[1]] + 1;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N + 2][M + 2];
        visit = new int[N + 2][M + 2];
        for(int i = 1; i <= N; i++) {
            Arrays.fill(visit[i], N * M);
        }

        for(int i = 1; i <= N; i++) {
            char[] line = br.readLine().toCharArray();
            for(int j = 1; j <= M; j++) {
                map[i][j] = line[j - 1];
            }
        }
        q.offer(new int[] {1, 1});
        visit[1][1] = 1;
        search();
        System.out.println(visit[N][M]);
    }
}