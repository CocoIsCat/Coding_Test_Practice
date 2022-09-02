import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int channel = 100;
        int result = Math.abs(N - channel);
        int M = sc.nextInt();
        boolean[] broke = new boolean[10];

        for(int i = 0; i < M; i++) {
            broke[sc.nextInt()] = true;
        }
        if(result == 0) {
            System.out.println(result);
            System.exit(0);
        }
        else {
            for(int i = 0; i <= 1000000; i++) {
                char[] num = Integer.toString(i).toCharArray();
                boolean b = true;
                int count = 0;
                for (int j = 0; j < num.length; j++) {
                    if (!broke[(int)(num[j] - '0')]) {
                        count++;
                    }
                    else {
                        b = false;
                        break;
                    }
                }
                if (b) {
                    result = Math.min(result, Math.abs(N - i) + count);
                }
            }
        }
        System.out.println(result);
    }
}