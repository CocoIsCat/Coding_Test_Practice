import java.util.*;

class Main {
    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();
        int five = 0;

        for(int i = 1; i <= N; i++) {
            if(i % 5 == 0) {
                int temp = i;
                while(temp % 5 == 0) {
                    five++;
                    temp /= 5;
                }
            }
        }
        System.out.println(five);
    }
}