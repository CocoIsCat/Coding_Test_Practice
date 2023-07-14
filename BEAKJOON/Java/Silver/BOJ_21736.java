import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br;
    static int N, M;
    static char[][] map;
    static int[] me;
    static boolean visited[][];
    static int result = 0;
    
    static void BFS() {
        Queue<int[]> q = new LinkedList<>();
        int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        q.offer(me);
        while(!q.isEmpty()) {
            int[] axis = q.poll();
            int y = axis[0];
            int x = axis[1];
            for(int[] m : move) {
                int new_y = y + m[0];
                int new_x = x + m[1];
                if(new_y >= 0 && new_y < N && new_x >= 0 && new_x < M) {
                    if(map[new_y][new_x] != 'X') {
                        if(map[new_y][new_x] == 'P' && !visited[new_y][new_x]) {
                            result++;
                        }
                        if(!visited[new_y][new_x]) {
                        	q.offer(new int[] {new_y, new_x});
                        	visited[new_y][new_x] = true;
                        }
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];
        me = new int[2];
        
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'I') {
                    me[0] = i;
                    me[1] = j;
                }
            }
        }
        BFS();
        if(result != 0) {
            System.out.println(result);
        } else {
            System.out.println("TT");
        }
    }
}