package BEAKJOON.Java.Gold;

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            Queue<Long> maxPQ = new PriorityQueue<>();
            Queue<Long> minPQ = new PriorityQueue<>();
            Map<Long, Integer> map = new HashMap<>();

            while(k-- > 0) {
                st = new StringTokenizer(br.readLine());
                String op = st.nextToken();
                long data = Long.parseLong(st.nextToken());

                //삽입
                if(op.equals("I")) {
                    if(!map.containsKey(data)) {
                        map.put(data, 1);
                    }
                    else {
                        int value = map.get(data);
                        map.replace(data, value + 1);
                    }
                    maxPQ.offer(data * -1);
                    minPQ.offer(data);
                }

                //삭제
                else {

                    //최대
                    if(data == 1) {
                        while (!maxPQ.isEmpty()) {
                            long key = maxPQ.poll() * -1;
                            if (map.get(key) > 0) {
                                int value = map.get(key);
                                map.replace(key, value - 1);
                                break;
                            }
                        }
                    }

                    //최소
                    else {
                        while (!minPQ.isEmpty()) {
                            long key = minPQ.poll();
                            if (map.get(key) > 0) {
                                int value = map.get(key);
                                map.replace(key, value - 1);
                                break;
                            }
                        }
                    }
                }
            }

            long max = Long.MIN_VALUE;
            long min = Long.MAX_VALUE;
            boolean flag = false;
            for (long key : map.keySet()) {
                if (map.get(key) > 0) {
                    max = Math.max(max, key);
                    min = Math.min(min, key);
                    flag = true;
                }
            }
            if(flag)
                bw.write(max + " " + min + "\n");
            else
                bw.write("EMPTY\n");
        }
        bw.close();
    }
}
