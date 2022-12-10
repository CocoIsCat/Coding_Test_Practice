package BEAKJOON.Java.Silver;

import java.util.*;
import java.io.*;
class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        Map<String, String> map = new HashMap<>();
        while(N-- > 0) {
            String[] str1 = br.readLine().split(" ");
            map.put(str1[0], str1[1]);
        }
        while(M-- > 0) {
            String str2 = br.readLine();
            bw.write(map.get(str2) + "\n");
        }
        bw.close();
    }
}