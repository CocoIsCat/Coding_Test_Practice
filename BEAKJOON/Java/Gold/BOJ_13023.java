import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, M;
        N = sc.nextInt();
        M = sc.nextInt();
        boolean[][] arrGraph = new boolean[N][N];
        List<List<Integer>> listGraph = new ArrayList<>();
        List<int[]> edgeGraph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            listGraph.add(new ArrayList<>());
        }
        while (M-- > 0) {
            int p1 = sc.nextInt();
            int p2 = sc.nextInt();
            arrGraph[p1][p2] = true;
            arrGraph[p2][p1] = true;
            listGraph.get(p1).add(p2);
            listGraph.get(p2).add(p1);
            edgeGraph.add(new int[]{p1, p2});
            edgeGraph.add(new int[]{p2, p1});
        }

        for(int i = 0; i < edgeGraph.size(); i++) {
            for(int j = 0; j < edgeGraph.size(); j++) {
                int A = edgeGraph.get(i)[0];
                int B = edgeGraph.get(i)[1];
                int C = edgeGraph.get(j)[0];
                int D = edgeGraph.get(j)[1];
                if (A != C && A != D && B != C && B != D) {
                    if (arrGraph[B][C]) {
                        for (int E : listGraph.get(D)) {
                            if (A == E || B == E || C == E || D == E) {
                                continue;
                            }
                            System.out.println(1);
                            System.exit(0);
                        }
                    }
                }
            }
        }
        System.out.println(0);
    }
}