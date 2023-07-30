import java.util.*;
import java.io.*;

public class BOJ_20529 {

    private static int calc(String m1, String m2) {
        int result = 0;
        for (int i = 0; i < 4; i++) {
            if (m1.charAt(i) != m2.charAt(i)) {
                result++;
            }
        }
        return result;
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            List<String> mbtis = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int result = 100;
            if(N > 32) {
                result = 0;
            } else {
                for (int i = 0; i < N; i++) {
                    mbtis.add(st.nextToken());
                }
                for (int i = 0; i < N; i++) {
                    for (int j = i + 1; j < N; j++) {
                        for (int k = j + 1; k < N; k++) {
                            result = Math.min(result, calc(mbtis.get(i), mbtis.get(j))+
                                    calc(mbtis.get(i), mbtis.get(k))+
                                    calc(mbtis.get(j), mbtis.get(k)));
                        }
                    }
                }
            }
            bw.write(result + "\n");
        }
        bw.close();
    }
}
