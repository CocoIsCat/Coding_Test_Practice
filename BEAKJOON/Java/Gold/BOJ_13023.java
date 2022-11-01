import java.util.*;

/*시간 초과*/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean result = false;
        int N, M;
        N = sc.nextInt();
        M = sc.nextInt();
        boolean[][] arrGraph = new boolean[N][N];
        List<List<Integer>> listGraph = new ArrayList<>();
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
        }
        for (int i = 0; i < N; i++) {
            List<Integer> path = new ArrayList<>();
            path.add(i);
            List<Integer> node1 = listGraph.get(i);
            for (int j = 0; j < node1.size(); j++) {
                if (!path.contains(node1.get(j))) {
                    List<Integer> node2 = listGraph.get(node1.get(j));
                    path.add(node1.get(j));
                    for (int l = 0; l < node2.size(); l++) {
                        if (!path.contains(node2.get(l))) {
                            List<Integer> node3 = listGraph.get(node2.get(l));
                            path.add(node2.get(l));
                            for (int k = 0; k < node3.size(); k++) {
                                if (!path.contains(node3.get(k))) {
                                    List<Integer> node4 = listGraph.get(node3.get(k));
                                    path.add(node3.get(k));
                                    for (int n = 0; n < node4.size(); n++) {
                                        if (!(path.contains(node4.get(n)))) {
                                            int node5 = node3.get(k);
                                            path.add(node3.get(k));
                                            for (int m = 0; m < N; m++) {
                                                if (arrGraph[node5][m] == true) {
                                                    if (!path.contains(m)) {
                                                        result = true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (result)
            System.out.println(1);
        else
            System.out.println(0);
    }
}