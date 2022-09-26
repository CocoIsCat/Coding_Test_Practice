package BEAKJOON.Java.Bronze;

import java.util.*;
public class BOJ_2675 {
    public static void main(String[] args) {
        //String alNum = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\$%*+-./:";
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for(int i = 0; i < num; i++) {
            StringBuffer sb = new StringBuffer();
            int R = sc.nextInt();
            String str = sc.next();
            char[] cArr = str.toCharArray();
            for(int j = 0; j < cArr.length; j++) {
                for(int k = 0; k < R; k++) {
                    sb.append(String.valueOf(cArr[j]));
                }
            }
            System.out.println(sb.toString());
        }
    }
}