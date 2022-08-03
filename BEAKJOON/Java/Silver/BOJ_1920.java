import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashSet<String> set = new HashSet<>();

        int n = sc.nextInt();
        while(n-- > 0) {
            set.add(sc.next());
        }
        int m = sc.nextInt();
        while(m-- > 0) {
            String s = sc.next();
            if(set.contains(s)) {
                bw.write("1\n");
            }
            else {
                bw.write("0\n");
            }
        }
        bw.flush();
    }
}