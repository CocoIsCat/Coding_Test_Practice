import java.util.*;
import java.io.*;
public class BOJ_1149 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[][] index = {{1, 2}, {0, 2}, {0, 1}};
    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][3];
        int[] memo = new int[3];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        memo[0] = map[0][0];
        memo[1] = map[0][1];
        memo[2] = map[0][2];

        for(int i = 1; i < N; i++) {
            int[] temp = new int[3];
            for (int j = 0; j < 3; j++) {
                int num1 = map[i][j] + memo[index[j][0]];
                int num2 = map[i][j] + memo[index[j][1]];
                temp[j] = Math.min(num1, num2);
            }
            memo = temp;
        }
        int result = Integer.MAX_VALUE;
        for (int m : memo) {
            result = Math.min(m, result);
        }
        System.out.println(result);
    }
}
