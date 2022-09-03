import java.util.*;

class Main {
    static int[][] board = new int[501][501];

    public static int fourone(int x, int y) {
        int sum = 0;
        for(int i = x; i < x + 4; i++) {
            sum += board[i][y];
        }
        return sum;
    }

    public static int onefour(int x, int y) {
        int sum = 0;
        for(int i = y; i < y + 4; i++) {
            sum += board[x][i];
        }
        return sum;
    }

    public static int twotwo(int x, int y) {
        int sum = 0;
        for(int i = x; i < x + 2; i++) {
            for(int j = y; j < y + 2; j++) {
                sum += board[i][j];
            }
        }
        return sum;
    }

    public static int twothree(int x, int y) {
        int sum = 0;
        int result = 0;
        for(int i = x; i < x + 2; i++) {
            for(int j = y; j < y + 3; j++) {
                sum += board[i][j];
            }
        }
        result = Math.max(result, (sum - (board[x][y] + board[x][y + 1])));
        result = Math.max(result, (sum - (board[x][y] + board[x][y + 2])));
        result = Math.max(result, (sum - (board[x][y] + board[x + 1][y + 2])));
        result = Math.max(result, (sum - (board[x][y + 1] + board[x][y + 2])));
        result = Math.max(result, (sum - (board[x + 1][y] + board[x][y + 2])));
        result = Math.max(result, (sum - (board[x + 1][y] + board[x + 1][y + 2])));
        result = Math.max(result, (sum - (board[x + 1][y] + board[x + 1][y + 1])));
        result = Math.max(result, (sum - (board[x + 1][y + 1] + board[x + 1][y + 2])));
        return result;
    }

    public static int threetwo(int x, int y) {
        int sum = 0;
        int result = 0;
        for(int i = x; i < x + 3; i++) {
            for(int j = y; j < y + 2; j++) {
                sum += board[i][j];
            }
        }
        result = Math.max(result, (sum - (board[x][y] + board[x + 1][y])));
        result = Math.max(result, (sum - (board[x][y] + board[x + 2][y])));
        result = Math.max(result, (sum - (board[x][y] + board[x + 2][y + 1])));
        result = Math.max(result, (sum - (board[x][y + 1] + board[x + 2][y])));
        result = Math.max(result, (sum - (board[x + 1][y] + board[x + 2][y])));
        result = Math.max(result, (sum - (board[x][y + 1] + board[x + 2][y + 1])));
        result = Math.max(result, (sum - (board[x][y + 1] + board[x + 1][y + 1])));
        result = Math.max(result, (sum - (board[x + 1][y + 1] + board[x + 2][y + 1])));
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int result = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++){
                board[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < N - 3; i++) {
            for(int j = 0; j < M; j++) {
                result = Math.max(result, fourone(i, j));
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M - 3; j++) {
                result = Math.max(result, onefour(i, j));
            }
        }

        for(int i = 0; i < N - 1; i++) {
            for(int j = 0; j < M - 1; j++) {
                result = Math.max(result, twotwo(i, j));
            }
        }

        for(int i = 0; i < N - 1; i++) {
            for(int j = 0; j < M - 2; j++) {
                result = Math.max(result, twothree(i, j));
            }
        }

        for(int i = 0; i < N - 2; i++) {
            for(int j = 0; j < M - 1; j++) {
                result = Math.max(result, threetwo(i, j));
            }
        }
        System.out.println(result);
    }
}