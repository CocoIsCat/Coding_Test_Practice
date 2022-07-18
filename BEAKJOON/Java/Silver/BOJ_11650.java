import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for(int i = 0; i < N; i++) {
            String str1 = br.readLine();
            String[] str2 = str1.split(" ");
            arr[i][0] = Integer.parseInt(str2[0]);
            arr[i][1] = Integer.parseInt(str2[1]);
        }
        Arrays.sort(arr, (o1, o2) -> {
            if(o1[0] == o2[0]){
                return o1[1] - o2[1];
            }
            else{
                return o1[0] - o2[0];
            }
        });

        for(int i =0; i < N; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }

    }
}