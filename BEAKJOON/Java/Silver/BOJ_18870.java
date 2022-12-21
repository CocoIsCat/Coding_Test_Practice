package BEAKJOON.Java.Silver;

import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Map<Integer, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];
        List<Integer> zip = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            input[i] = num;
            zip.add(num);
        }
        Collections.sort(zip);

        int value = 0;
        for (int key : zip) {
            if (!map.containsKey(key)) {
                map.put(key, value++);
            }
        }

        for (int i : input) {
            bw.write(map.get(i) + " ");
        }
        bw.close();
    }
}