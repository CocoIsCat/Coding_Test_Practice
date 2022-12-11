package BEAKJOON.Java.Gold;

import java.util.*;
import java.io.*;
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringBuilder sb = new StringBuilder();
            char[] op = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            Deque<String> dq = new LinkedList<>();
            String str1 = br.readLine();
            str1 = str1.replace("[", "");
            str1 = str1.replace("]", "");
            String[] sArr = str1.split(",");
            boolean flag = true;
            boolean result = false;
            for (String str : sArr) {
                dq.add(str);
            }
            for (char c : op) {
                if (c == 'R') {
                    flag = !flag;
                } else {
                    if (n - 1 >= 0) {
                        if (flag) {
                            dq.removeFirst();
                            n--;
                        } else {
                            dq.removeLast();
                            n--;
                        }
                    } else {
                        bw.write("error\n");
                        result = true;
                        break;
                    }
                }
            }
            if (!result) {
                if (dq.size() == 0) {
                    bw.write("[]\n");
                } else {
                    sb.append("[");
                    if (flag) {
                        for (int i = 0; i < n - 1; i++) {
                            sb.append(dq.pollFirst() + ",");
                        }
                        sb.append(dq.pollFirst() + "]\n");
                    } else {
                        for (int i = 0; i < n - 1; i++) {
                            sb.append(dq.pollLast() + ",");
                        }
                        sb.append(dq.pollLast() + "]\n");
                    }
                }
                bw.write(sb.toString());
            }
        }
        bw.close();
    }
}