package BEAKJOON.Java.Gold;

import java.util.*;
import java.io.*;

public class BOJ_16236 {

    static int[][] map;
    static int N;
    static int size;
    static int[] shark;
    static List<List<int[]>> node;
    static int time = 0;
    static int exp = 2;

    static void move() {
        while (true) {
            int[] fish = bfs(shark);
            if (fish[0] != -1 && fish[1] != -1) {
                exp--;
                time += fish[2];
                if (exp == 0) {
                    size++;
                    exp = size;
                }
                shark[0] = fish[0];
                shark[1] = fish[1];
                map[fish[0]][fish[1]] = 0;
            } else {
                break;
            }
        }
    }

    static int[] bfs(int[] start) {
        int[][] visited = new int[N][N];
        int[][] move = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        int[] fish = new int[] {-1, -1, -1};
        int length = Integer.MAX_VALUE;
        List<int[]> candidate = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        while (!q.isEmpty()) {
            int[] c = q.poll();
            int y = c[0];
            int x = c[1];
            if(map[y][x] != 0 && map[y][x] < size) {
                if (visited[y][x] < length) {
                    candidate = new ArrayList<>();
                    length = visited[y][x];
                } if (visited[y][x] <= length) {
                    candidate.add(new int[]{y, x, length});
                }
            }
            for (int[] m : move) {
                int ny = y + m[0];
                int nx = x + m[1];
                if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
                    if (visited[ny][nx] == 0 && map[ny][nx] <= size) {
                        q.offer(new int[] {ny, nx});
                        visited[ny][nx] = visited[y][x] + 1;
                    }
                }
            }
        }
        if(!candidate.isEmpty()) {
            candidate.sort((o1, o2) -> {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            });
            fish = candidate.get(0);
        }
        return fish;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        size = 2;
        StringTokenizer st;
        map = new int[N][N];
        node = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            node.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9) {
                    shark = new int[] {i, j};
                    map[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < N; i++) {
            node.get(1).sort(((o1, o2) -> {
                if(o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }));
        }
        move();
        System.out.println(time);
    }
}
