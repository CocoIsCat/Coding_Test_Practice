import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> right = new Stack<>();
        Stack<Character> left = new Stack<>();
        String ini = bf.readLine();
        int M = Integer.parseInt(bf.readLine());
        for(char ch : ini.toCharArray()) {
            left.push(ch);
        }

        while(M-- > 0) {
            String cmd = bf.readLine();
            String[] op = cmd.split(" ");
            char tmp;
            if(op[0].charAt(0) == 'L') {
                if(!left.isEmpty()) {
                    tmp = left.pop();
                    right.push(tmp);
                }
            }
            else if(op[0].charAt(0) == 'D') {
                if(!right.isEmpty()) {
                    tmp = right.pop();
                    left.push(tmp);
                }
            }
            else if(op[0].charAt(0) == 'B') {
                if(!left.isEmpty()) {
                    left.pop();
                }
            }
            else if(op[0].charAt(0) == 'P') {
                left.push(op[1].charAt(0));
            }
        }
        for(char ch : left) {
            sb.append(ch);
        }
        while(!right.isEmpty()) {
            sb.append(right.pop());
        }
        System.out.println(sb);
    }
}