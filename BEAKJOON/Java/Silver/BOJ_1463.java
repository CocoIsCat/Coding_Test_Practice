import java.util.*;

class Main {
    static int[] memo = new int[1000001];
    public static int func(int n) {
        if(n == 1) {
            return 0;
        }
        if(memo[n] > 0) {
            return memo[n];
        }
        memo[n] = func(n - 1) + 1;
        if(n % 3 == 0) {
            int count = func(n / 3) + 1;
            if(memo[n] > count) {
                memo[n] = count;
            }
        }
        if(n % 2 == 0) {
            int count = func(n / 2) + 1;
            if(memo[n] > count) {
                memo[n] = count;
            }
        }
        return memo[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(func(sc.nextInt()));
    }
}
