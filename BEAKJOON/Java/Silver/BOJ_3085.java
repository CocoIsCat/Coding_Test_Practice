import java.util.*;
import java.io.*;
class Main {

    public static char[][] swap(char[][] board, int x1, int y1, int x2, int y2){
        if(board[x1][y1] != board[x2][y2]) {
            char temp = board[x1][y1];
            board[x1][y1] = board[x2][y2];
            board[x2][y2] = temp;
        }
        return board;
    }

    public static int check(char[][] board) {
        int eat = 1;

        /*가로줄*/
        for(int i = 1; i <= board.length - 2; i++) {
            char prev = board[i][1];
            int count = 1;
            for(int j = 2; j <= board.length - 2; j++) {
                if(prev == board[i][j]) {
                    count++;
                    eat = Math.max(eat, count);
                }
                else {
                    prev = board[i][j];
                    eat = Math.max(eat, count);
                    count = 1;
                }
            }
        }

        for(int i = 1; i <= board.length - 2; i++) {
            char prev = board[1][i];
            int count = 1;
            for(int j = 2;  j <= board.length - 2; j++) {
                if(prev == board[j][i]) {
                    count++;
                    eat = Math.max(eat, count);
                }
                else {
                    prev = board[j][i];
                    eat = Math.max(eat, count);
                    count = 1;
                }
            }
        }
        return eat;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] board = new char[N + 2][N + 2];
        int eat = 1;

        for(int i = 1; i <= N; i++) {
            char[] tmp = br.readLine().toCharArray();
            for(int j = 1; j <= N; j++) {
                board[i][j] = tmp[j - 1];
            }
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                eat = Math.max(eat, check(swap(board, i, j, i - 1, j)));
                swap(board, i, j, i - 1, j);
                eat = Math.max(eat, check(swap(board, i, j, i + 1, j)));
                swap(board, i, j, i + 1, j);
                eat = Math.max(eat, check(swap(board, i, j, i, j - 1)));
                swap(board, i, j, i, j - 1);
                eat = Math.max(eat, check(swap(board, i, j, i, j + 1)));
                swap(board, i, j, i, j + 1);
            }
        }

        System.out.println(eat);
    }
}