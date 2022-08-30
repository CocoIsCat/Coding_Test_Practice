import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] memo = new int[11];
        int[] arr = new int[n];
        memo[0] = 1;
        memo[1] = 1;
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i = 2; i <= 10; i++) {
            if(i == 2) {
                memo[i] = memo[i - 2] + memo[i - 1];
            }
            else {
                memo[i] = memo[i - 3] + memo[i - 2] + memo[i - 1];
            }
        }
        for(int i = 0; i < n; i++) {
            System.out.println(memo[arr[i]]);
        }
    }
}