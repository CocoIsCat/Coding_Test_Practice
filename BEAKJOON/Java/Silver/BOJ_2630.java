package BEAKJOON.Java.Silver;

import java.io.*;

class Main {
    static int[][] map = new int[129][129];
    static int blue = 0;
    static int white = 0;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            int idx = 0;
            for(String s : line) {
                map[i][idx++] = Integer.parseInt(s);
            }
        }
        cut(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void cut(int x, int y, int size) {
        int count = 0;
        for(int i = x; i < x + size; i++) {
            for(int j = y; j < y + size; j++) {
                if(map[i][j] == 1)
                    count++;
            }
        }
        if(count == size * size)
            blue++;
        else if(count == 0)
            white++;
        else {
            int i = size / 2;
            cut(x, y, size / 2);
            cut(x + i, y, size / 2);
            cut(x, y + i, size / 2);
            cut(x + i, y + i, size / 2);
        }
    }
}
