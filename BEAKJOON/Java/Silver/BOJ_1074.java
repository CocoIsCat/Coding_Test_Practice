package BEAKJOON.Java.Silver;

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();

        System.out.println(search(N , r, c));
    }

    static int search(int N, int r, int c) {
        int result = 0;
        int length = (int)Math.pow(2, N);

        if(N == 1) {
            if(r == 0 && c == 0)
                return 0;
            else if ( r == 0 && c == 1)
                return 1;
            else if (r == 1 && c == 0)
                return 2;
            else if (r == 1 && c == 1) {
                return 3;
            }
            return result;
        }
        else {
            if(r < length / 2 && c < length / 2) {
                result += search(N -1, r, c);
            }
            else if(r < length / 2 && c >= length / 2) {
                result += (long)Math.pow(2, 2 * N - 2);
                result += search(N - 1, r, c - (length / 2));
            }
            else if(r >= length / 2 && c < length / 2) {
                result += (long)Math.pow(2,  2 * N - 2) * 2;
                result += search(N - 1, r - (length / 2), c);
            }
            else if(r >= length / 2 && c >= length / 2) {
                result += (long)Math.pow(2, 2 * N - 2) * 3;
                result += search(N - 1, r - (length / 2), c - (length / 2));
            }
            return result;
        }
    }
}