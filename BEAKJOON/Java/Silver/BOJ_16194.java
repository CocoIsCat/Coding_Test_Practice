import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] price = new int[n + 1];
        int[] memo = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            price[i] = sc.nextInt();
        }
        memo[1] = price[1];

        for(int i = 2; i <= n; i++) {
            memo[i] = price[i];
            for(int j = 1; j <= i; j++) {
                int tmp = memo[j] + memo[i - j];
                memo[i] = memo[i] < tmp ? memo[i] : tmp;
            }
        }
        System.out.println(memo[n]);
    }
}