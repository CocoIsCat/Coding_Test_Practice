import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc. nextInt();
        int nf = 1;
        int kf = 1;
        for(int i = 0; i < k; i++) {
            nf *= (n - i);
        }
        for(int i = 1; i <= k; i++) {
            kf *= i;
        }
        System.out.println(nf/kf);
    }
}
