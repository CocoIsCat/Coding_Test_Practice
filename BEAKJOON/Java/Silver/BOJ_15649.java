import java.util.*;

class Main {
    static boolean[] num = new boolean[9];
    static int[] candi = new int[9];
    static StringBuilder sb = new StringBuilder();

    static void func(int i, int N, int M) {
        if(i == M) {
            for(int j = 0; j < M; j++) {
                sb.append(candi[j]);
                if(j != M - 1)
                    sb.append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int j = 1; j <= N; j++) {
            if(!num[j]) {
                num[j] = true;
                candi[i] = j;
                func(i + 1, N, M);
                num[j] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        func(0, N, M);
        System.out.println(sb.toString());
    }
}