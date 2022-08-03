import java.util.*;

class Main {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        int num = 0;
        int count = 0;

        while(true) {
            if(Integer.toString(num).contains("666")) {
                count++;
                if(count == n) {
                    System.out.println(num);
                    return;
                }
                else {
                    num++;
                }
            }
            else {
                num++;
            }
        }
    }
}