package BEAKJOON.Java.Gold;

import java.util.*;
import java.io.*;

class Main {
    static Queue<int[]> q = new LinkedList<>();
    static int[][] visit = new int[1001][1001];
    static int[][] map = new int[1001][1001];
    static int M;
    static int N;
    static int result = 0;
    static int remain = 0;

    public static void BFS() {
        int[][] point = new int[][] {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        while (!q.isEmpty()) {
            int[] tomato = q.poll();
            remain--;
            for(int[] i : point) {
                int[] newTomato = new int[]{tomato[0] + i[0], tomato[1] + i[1]};

                //좌표 유효성 검증
                if (newTomato[0] >= 0 && newTomato[0] < M) {
                    if (newTomato[1] >= 0 && newTomato[1] < N) {

                        //탐색 여부
                        if (visit[newTomato[0]][newTomato[1]] < 0) {
                            visit[newTomato[0]][newTomato[1]] = visit[tomato[0]][tomato[1]] + 1;
                            if (visit[newTomato[0]][newTomato[1]] > result)
                                result = visit[newTomato[0]][newTomato[1]];
                            q.offer(newTomato);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                int tomato = Integer.parseInt(st.nextToken());
                map[j][i] = tomato;

                //익은 토마토
                if(tomato == 1) {
                    q.offer(new int[] {j, i});
                    remain++;
                }

                //안 익은 토마토
                else if (tomato == 0) {
                    visit[j][i] = -1;
                    remain++;
                }

                //빈 칸
                else if (tomato == -1) {
                    visit[j][i] = 1;
                }
            }
        }
        BFS();

        if(remain == 0)
            System.out.println(result);
        else
            System.out.println(-1);
    }
}
