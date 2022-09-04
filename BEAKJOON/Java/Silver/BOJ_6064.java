import java.util.*;

class Main {

    private static int GCD(int a, int b) {
        if (b == 0){
            return a;
        }
        return GCD(b, a % b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int M = sc.nextInt();
            int N = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int result = x;
            int gcd = GCD(M, N);

            while (result <= ((M * N) / gcd)) {
                int y_temp = result % N;
                if(y_temp == 0) {
                    y_temp = N;
                }
                if (y_temp == y) {
                    System.out.println(result);
                    break;
                }
                result += M;
            }
            if(result > ((M * N) /gcd)) {
                System.out.println(-1);
            }
        }
    }
}