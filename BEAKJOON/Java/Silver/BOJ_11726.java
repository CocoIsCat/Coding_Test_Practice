import java.util.*;

class Main{
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        int[] memo = new int[1001];
        memo[0] = 1;
        memo[1] = 1;
        for(int i = 2; i <= n; i++) {
            memo[i] = memo[i - 2] + memo[i - 1];
        }
        System.out.println(memo[n] % 10007);
    }
}