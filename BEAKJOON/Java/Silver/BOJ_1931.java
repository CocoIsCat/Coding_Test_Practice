package BEAKJOON.Java.Silver;

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] arr = new int[N][2];
        int count = 0;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (a1, a2) -> a1[1] == a2[1] ? a1[0] - a2[0] : a1[1] - a2[1]);

        int end = -1;

        for(int i = 0; i < N; i++) {
            if(arr[i][0] >= end) {
                end = arr[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}