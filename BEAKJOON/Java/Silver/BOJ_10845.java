import java.io.IOException;
import java.util.*;
import java.io.*;
class Main {
    public static void main(String[] args)throws IOException {
        Queue q = new LinkedList();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String end = new String();

        for (int i = 0; i < n; i++) {
            String stm = br.readLine();
            String[] cmd = stm.split(" ");
            if (cmd[0].equals("push")) {
                q.offer(cmd[1]);
                end = cmd[1];
            } else if (cmd[0].equals("pop")) {
                if(!q.isEmpty()) {
                    System.out.println(q.poll());
                }
                else {
                    System.out.println("-1");
                }
            } else if (cmd[0].equals("size")) {
                System.out.println(q.size());
            } else if (cmd[0].equals("empty")) {
                boolean r = q.isEmpty();
                if (r) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            } else if (cmd[0].equals("front")) {
                if(!q.isEmpty()) {
                    System.out.println(q.peek());
                }
                else {
                    System.out.println("-1");
                }
            } else if (cmd[0].equals("back")) {
                if(!q.isEmpty()) {
                    System.out.println(end);
                }
                else {
                    System.out.println("-1");
                }
            }
        }
    }
}