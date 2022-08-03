import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int last = 1;
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= n; i++) {
            q.offer(i);
        }
        while(!(q.size() == 1)) {
            q.poll();
            last = q.poll();
            q.offer(last);
        }
        System.out.println(last);
    }
}