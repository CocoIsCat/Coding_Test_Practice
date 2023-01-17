package BEAKJOON.Java.Silver;

import javax.sound.sampled.ReverbType;
import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> positivePQ = new PriorityQueue<>();
        PriorityQueue<Integer> negativePQ = new PriorityQueue<>();
        while(N-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if(x == 0) {
                if (positivePQ.isEmpty() && negativePQ.isEmpty()) {
                    bw.write(0 + "\n");
                    continue;
                }
                if(negativePQ.isEmpty()){
                    bw.write(positivePQ.poll() + "\n");
                    continue;
                }
                if (positivePQ.isEmpty()) {
                    bw.write(negativePQ.poll() * -1 + "\n");
                    continue;
                }
                if (positivePQ.peek() >= negativePQ.peek()) {
                    bw.write(negativePQ.poll() * -1 + "\n");
                } else {
                    bw.write(positivePQ.poll() + "\n");
                }

            } else if (x > 0) {
                positivePQ.add(x);
            } else if (x < 0) {
                negativePQ.add(x * -1);
            }
        }
        bw.close();
    }
}