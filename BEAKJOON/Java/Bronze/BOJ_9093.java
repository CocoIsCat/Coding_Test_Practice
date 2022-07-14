import java.util.*;
import java.io.*;

public class BOJ_9093 {
    public static void main(String[] args) throws IOException {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        int num = Integer.parseInt(br.readLine());

        OutputStreamWriter osw = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(osw);

        while(num-- > 0) {
            String str = br.readLine() + "\n";
            Stack<Character> s = new Stack<>();
            for(char ch : str.toCharArray()) {
                if(ch == ' ' || ch == '\n') {
                    while(!s.isEmpty()) {
                        bw.write(s.pop());
                    }
                    bw.write(ch);
                }
                else {
                    s.push(ch);
                }
            }
        }
        bw.flush();
    }
}