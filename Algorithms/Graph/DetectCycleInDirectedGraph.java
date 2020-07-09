/**
 * Created on 27 Jun 2019 by happygirlzt
 *
 * Detect Cycle in Directed Graph by DFS
 *
 */
import java.util.*;

public class DetectCycleInDirectedGraph {
    public static boolean hasCycle(int n, int[][] edges) {
        List<Integer>[] g = new List[n];
        int[] colors = new int[n];
        buildGraph(g, edges);

        for (int i = 0; i < n; i++) {
            if (colors[i] == 0 && dfs(g, i, colors)) return true;
        }

        return false;
    }

    private static boolean dfs(List<Integer>[] g, int cur, int[] colors) {
        if (g[cur] == null || g[cur].size() == 0) return false;

        colors[cur] = 1;
        for (int next : g[cur]) {
            if (colors[next] == 1) return true;
            if (colors[next] == 0 && dfs(g, next, colors)) return true;
        }

        colors[cur] = 2;
        return false;
    }

    private static void buildGraph(List<Integer>[] g, int[][] edges) {
        for (int[] e : edges) {
            int from = e[0];
            int to = e[1];
            if (g[from] == null) {
                g[from] = new LinkedList<>();
            }

            g[from].add(to);
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {2, 3}};
        int source = 0, destination = 3;

        System.out.println(hasCycle(n, edges));
    }
}
