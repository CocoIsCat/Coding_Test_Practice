import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while(T-- > 0) {
            int k = sc.nextInt();
            int n = sc.nextInt();
            int[][] apt = new int[15][15];

            for(int i = 1; i <= n; i++) {
                apt[0][i] = i;
            }

            for(int i = 1; i <= k; i++) {
                for(int j = 1; j <= n; j++) {
                    for(int t = 1; t <= j; t++) {
                        apt[i][j] += apt[i - 1][t];
                    }
                }
            }
            System.out.println(apt[k][n]);
        }
    }
}