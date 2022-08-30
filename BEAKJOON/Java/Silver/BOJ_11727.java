import java.util.*;

class Main {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        int[] memo = new int[1001];
        memo[0] = 1;
        memo[1] = 1;
        memo[2] = 3;

        for(int i = 3; i <= n; i++) {
            memo[i] = memo[i - 1] + (memo[i - 2] * 2);
            memo[i] %= 10007;
        }
        System.out.println(memo[n]);
    }
}