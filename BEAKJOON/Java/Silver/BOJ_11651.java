import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for(int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(tmp[0]);
            arr[i][1] = Integer.parseInt(tmp[1]);
        }
        Arrays.sort(arr, new Comparator<int[]>(){
            @Override
            public int compare(int[] a1, int[] a2) {
                if(a1[1] == a2[1]) {
                    return a1[0] - a2[0];
                }
                else {
                    return a1[1] - a2[1];
                }
            }
        });

        for(int[] a : arr) {
            System.out.println(a[0] + " " + a[1]);
        }
    }
}