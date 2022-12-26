package BEAKJOON.Java.Silver;

import java.util.*;

class Main {
    static boolean[] visit = new boolean[100001];
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static Queue<int[]> q = new LinkedList<>();
    static int start;
    static int finish;

    static int result;
    static void DFS(int N) {
        while(!q.isEmpty()) {
            int[] node = q.poll();
            if (node[0] == finish) {
                result = node[1];
                break;
            }
            if(!visit[node[0]]) {
                visit[node[0]] = true;
                int[] make = {-1, +1, node[0]};
                graph.put(node[0], new ArrayList<>());
                for(int i : make) {
                    if (node[0] + i >= 0 && node[0] + i <= 100000) {
                        graph.get(node[0]).add(node[0] + i);
                        q.offer(new int[]{node[0] + i, node[1] + 1});
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        start = sc.nextInt();
        finish = sc.nextInt();
        q.offer( new int[] {start, 0});
        DFS(start);
        System.out.println(result);

    }
}