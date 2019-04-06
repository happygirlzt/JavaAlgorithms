/**
 * Created on 6 Apr 2019 by happygirlzt
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

class DetectCycleInUndirectedGraphByBFS {
    public static void main(String[] arg) {
        int V = 5;
        Map<Integer, Set<Integer>> g = new HashMap<>();
        int[][] edges = {{0, 1}, {1, 2}, {0, 3}, {0, 2}, {3, 4}};
        buildGraph(g, edges);

        if (hasCycle(g, V)) {
            System.out.println("This graph has cycle");
        } else {
            System.out.println("This graph does not have cycle");
        }
    }

    private static void buildGraph(Map<Integer, Set<Integer>> g, int[][] edges) {
        for (int[] edge : edges) {
            g.putIfAbsent(edge[0], new HashSet<>());
            g.putIfAbsent(edge[1], new HashSet<>());
            g.get(edge[0]).add(edge[1]);
            g.get(edge[1]).add(edge[0]);
        }
    }

    public static boolean hasCycle(Map<Integer, Set<Integer>> g, int V) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i] && bfs(g, i, V, visited)) return true;
        }

        return false;
    }

    private static boolean bfs(Map<Integer, Set<Integer>> g, int s, int V, boolean[] visited) {
        int[] parent = new int[V];
        Arrays.fill(parent, -1);

        Queue<Integer> q = new LinkedList<>();

        visited[s] = true;
        q.add(s);

        while (!q.isEmpty()) {
            int u = q.poll();

            if (g.get(u).size() == 0) continue;
            for (int v : g.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    q.offer(v);
                    parent[v] = u;
                } else if (parent[u] != v) return true;
            }
        }

        return false;
    }
}
