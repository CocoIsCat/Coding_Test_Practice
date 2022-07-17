import java.util.*;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Stack<Integer> s = new Stack<>();
        int n = sc.nextInt();
        int[] arr = new int[n];
        StringBuilder sb = new StringBuilder();
        int num = 0;
        int index = 0;

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int sNum = arr[index];

        while (true) {
            if (sNum > num) {
                s.push(++num);
                sb.append("+\n");
            }
            if (sNum <= num) {
                if (s.peek() == sNum) {
                    s.pop();
                    sb.append("-\n");
                    if(index + 1 != n) {
                        sNum = arr[++index];
                    }
                    else {
                        break;
                    }
                }
                else {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println(sb);
    }
}