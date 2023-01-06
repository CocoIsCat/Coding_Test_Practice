package BEAKJOON.Java.Silver;

import java.io.*;

class Main {
    static String[] map;
    static StringBuilder result = new StringBuilder();

    static void zip(int row, int col, int size){
        if(size == 1) {
            if(map[row].charAt(col) == '1')
                result.append(1);
            else
                result.append(0);
        }

        else {
            boolean flag = true;
            char ch = map[row].charAt(col);
            for(int i = row; i < row + size; i++) {
                for(int j = col; j < col + size; j++){
                    if(ch != map[i].charAt(j)) {
                        flag = false;
                        break;
                    }
                }
            }

            if(flag) {
                result.append(ch);
            }
            else {
                result.append("(");
                zip(row, col, size / 2);
                zip(row, col + size / 2, size / 2);
                zip(row + size / 2, col, size / 2);
                zip(row + size / 2, col + size / 2, size / 2);
                result.append(")");
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new String[N];

        for(int i = 0; i < N ;i++) {
            map[i] = br.readLine();
        }

        zip(0, 0, N);

        System.out.println(result);
    }
}