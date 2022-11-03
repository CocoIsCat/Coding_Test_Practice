package BEAKJOON.Java.Bronze;

import java.util.*;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] grade = sc.next().toCharArray();
        double one = (double)(69 - (int)grade[0]);
        if(one - 0.0 < 0.00001)
            System.out.println(0.0);
        else {
            if (grade[1] == '+') {
                System.out.printf("%.1f", one + 0.3);
            } else if (grade[1] == '0') {
                System.out.printf("%.1f", one);
            } else {
                System.out.printf("%.1f", one - 0.3);
            }
        }
    }
}