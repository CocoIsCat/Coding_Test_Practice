import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] sang = new int[20000001];
        int n = sc.nextInt();
        while(n-- > 0) {
            int card = sc.nextInt();
            sang[card + 10000000]++;
        }
        int m = sc.nextInt();
        while(m-- > 0) {
            int card = sc.nextInt();
            bw.write(sang[card + 10000000] + " ");
        }
        bw.flush();
    }
}