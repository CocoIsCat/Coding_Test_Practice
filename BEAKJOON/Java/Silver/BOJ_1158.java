import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }
        System.out.printf("<");
        for (int j = 0; j < n - 1; j++) {
            for (int i = 1; i < k; i++) {
                int tmp = q.poll();
                q.offer(tmp);
            }
            int tmp = q.poll();
            System.out.printf("%d, ", tmp);
        }
        System.out.println(q.poll() + ">");
    }
}
