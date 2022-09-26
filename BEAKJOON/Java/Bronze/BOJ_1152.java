package BEAKJOON.Java.Bronze;

import java.util.*;
public class BOJ_1152 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] sArr = str.split(" ");

        try {
            if (sArr[0].equals("")) {
                System.out.println(sArr.length - 1);
            } else
                System.out.println(sArr.length);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("0");
        }
    }
}
