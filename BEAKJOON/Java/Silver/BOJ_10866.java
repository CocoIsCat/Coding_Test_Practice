import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());

        while(n-- > 0) {
            String[] str = br.readLine().split(" ");

            if(str[0].equals("push_back")) {
                dq.offerLast(Integer.parseInt(str[1]));
            }
            else if(str[0].equals("push_front")) {
                dq.offerFirst(Integer.parseInt(str[1]));
            }
            else if(str[0].equals("pop_front")) {
                if(dq.isEmpty()) {
                    bw.write("-1\n");
                }
                else {
                    bw.write(dq.pollFirst() + "\n");
                }
            }
            else if(str[0].equals("pop_back")) {
                if(dq.isEmpty()) {
                    bw.write("-1\n");
                }
                else {
                    bw.write(dq.pollLast() + "\n");
                }
            }
            else if(str[0].equals("size")) {
                bw.write(dq.size() + "\n");
            }
            else if(str[0].equals("empty")) {
                if(dq.isEmpty()) {
                    bw.write("1\n");
                }
                else {
                    bw.write("0\n");
                }
            }
            else if(str[0].equals("front")) {
                if(dq.isEmpty()) {
                    bw.write("-1\n");
                }
                else {
                    bw.write(dq.peekFirst() + "\n");
                }
            }
            else if(str[0].equals("back")) {
                if(dq.isEmpty()) {
                    bw.write("-1\n");
                }
                else {
                    bw.write(dq.peekLast() + "\n");
                }
            }
        }
        bw.flush();
    }
}