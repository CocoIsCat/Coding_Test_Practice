import java.util.*;
import java.io.*;

class Main {
    static int[] visit = new int[100001];
    static Queue<Integer> q = new LinkedList<>();
    static int start;
    static int finish;
    static int result;

    static void DFS() {
        while(!q.isEmpty()) {
            int node = q.poll();
            if (node == finish) {
                result = visit[node] + 1;
                break;
            }
            int[] make = {-1, +1, node};
            for(int i : make) {
                if(node + i >= 0 && node + i <= 100000) {
                    if(visit[node + i] == -1) {
                        q.offer(node + i);
                        visit[node + i] = visit[node] + 1;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        finish = Integer.parseInt(st.nextToken());
        Arrays.fill(visit, -1);
        q.offer(start);
        DFS();
        System.out.println(result);

    }
}