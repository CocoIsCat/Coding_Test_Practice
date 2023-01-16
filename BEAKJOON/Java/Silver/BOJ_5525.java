package BEAKJOON.Java.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();
        int result = 0;
        int count = 0;
        for (int i = 0; i < M - 2; i++) {
            if (S.charAt(i) == 'I') {
                if (S.charAt(i + 1) == 'O' && S.charAt(i + 2) == 'I') {
                    count++;
                    if (count == N) {
                        count--;
                        result++;
                    }
                }
                else
                    count = 0;
            }

        }
        System.out.println(result);
    }
}