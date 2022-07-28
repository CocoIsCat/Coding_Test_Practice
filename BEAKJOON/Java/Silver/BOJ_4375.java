import java.util.*;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int i = 0;
            int count = 1;

            while(true) {
                i = (i * 10 + 1) % n;
                if(i % n == 0) {
                    System.out.println(count);
                    break;
                }
                else {
                    count++;
                }
            }
        }
    }
}