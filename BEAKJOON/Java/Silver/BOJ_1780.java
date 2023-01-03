package BEAKJOON.Java.Silver;

import java.io.*;
import java.util.*;

class Main {
    static int[] result = new int[3];
    static String[] map;
    static void slice(int rStart, int cStart, int size) {
        if (size == 1) {
            result[Character.getNumericValue(map[rStart].charAt(cStart))]++;
        }
        else {
            String line = map[rStart].substring(cStart, cStart + size);
            boolean flag = true;
            if (line.length() + line.replace(line.substring(0, 1), "").length() == line.length()) {
                for (int i = rStart; i < rStart + size; i++) {
                    String str = map[i].substring(cStart, cStart + size);
                    if (!line.equals(str)) {
                        flag = false;
                        break;
                    }
                }
            } else {
                flag = false;
            }

            if (flag) {
                result[Character.getNumericValue(map[rStart].charAt(cStart))]++;
            } else {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        int r = rStart + (size / 3) * j;
                        int c = cStart + (size / 3) * i;
                        int s = size / 3;
                        slice(rStart + (size / 3) * i, cStart + (size / 3) * j, size / 3);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new String[N];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            str = str.replace("-1", "2");
            str = str.replace(" ", "");
            map[i] = str;
        }

        slice(0,0, map.length);

        System.out.println(result[2]);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}