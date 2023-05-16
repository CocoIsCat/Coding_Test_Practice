package BEAKJOON.Java.Gold;

import java.util.*;
import java.io.*;

class BOJ_9019 {
    public static int DSLR(int n, int order) {
        int result = 0;
        if (order == 0) {   //D
            result = n * 2 < 10000 ? n * 2 : (n * 2) % 10000;
        } else if (order == 1) {    //S
            result = n != 0 ? n - 1 : 9999;
        } else if (order == 2) {    //L
            int left = n / 1000;
            result = (n % 1000) * 10 + left;
        } else if (order == 3) {    //R
            int right = n % 10;
            result = right * 1000 + n / 10;
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] orders = {"D", "S", "L", "R"};
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            String[] answer = new String[10000];
            Arrays.fill(answer, "");
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            Queue<Integer> q = new LinkedList<>();
            q.offer(A);
            while (!q.isEmpty() && answer[B].length() == 0) {
                int current = q.poll();
                for (int i = 0; i < 4; i++) {
                    int next = DSLR(current, i);
                    if (answer[next].length() == 0 && current != next) {
                        q.offer(next);
                        answer[next] = answer[current] + orders[i];
                    }
                }
            }
            System.out.println(answer[B]);
        }
    }
}
