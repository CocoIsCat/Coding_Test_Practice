package BEAKJOON.Java.Bronze;

import java.util.Scanner;

public class BOJ_2908 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int revA = ((A % 10) * 100) + ((A % 100) - (A % 10)) + (A / 100);
        int revB = ((B % 10) * 100) + ((B % 100) - (B % 10)) + (B / 100);
        System.out.println(Math.max(revA, revB));
    }
}
