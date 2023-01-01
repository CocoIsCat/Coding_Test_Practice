package BEAKJOON.Java.Silver;

import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        String str = br.readLine();
        String[] plus = str.split("-");

        for(int i = 0; i < plus.length; i++) {
            String[] num = plus[i].split("\\+");
            int sum = 0;
            for(String j : num)
                sum += Integer.parseInt(j);
            if(i == 0)
                result += sum;
            else
                result -= sum;
        }
        System.out.println(result);
    }
}