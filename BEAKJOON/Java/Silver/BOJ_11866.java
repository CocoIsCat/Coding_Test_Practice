import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        int count = 0;
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= N; i++) {
            q.offer(i);
        }

        System.out.printf("<");	//괄호 열고
        for (int j = 0; j < n - 1; j++) {	//수가 하나 남을 때까지
            for (int i = 1; i < k; i++) {	//k-1번째 수까지 poll & offer
                int tmp = q.poll();
                q.offer(tmp);
            }
            int tmp = q.poll();
            System.out.printf("%d, ", tmp);
        }
        System.out.println(q.poll() + ">");	//마지막 수 꺼내기 & 괄호 닫기
    }
}