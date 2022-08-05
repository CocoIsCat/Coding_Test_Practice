import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int sum = 0;
        Stack<Integer> s = new Stack<>();

        while (k-- > 0) {
            int n = sc.nextInt();
            if (n != 0) {
                s.push(n);
            } else {
                s.pop();
            }
        }
        for(int i : s) {
            sum += i;
        }
        System.out.println(sum);
    }
}