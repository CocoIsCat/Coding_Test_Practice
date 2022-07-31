import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long sum = 0;
        int N = sc.nextInt();

        for(int i = 1; i <= N; i++) {
            sum += (N / i) * i;
        }
        System.out.println(sum);
    }
}