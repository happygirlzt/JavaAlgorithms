/**
 * Created on 15 May 2019 by happygirlzt
 *
 * Minimum spanning tree, Prim's Algorithm
 *
 * Credit to https://www.hackerearth.com/zh/practice/algorithms/graphs/minimum-spanning-tree/tutorial/
 */

import java.util.*;

class MST_Prim {
    static class Pair {
        int weight;
        int y;
        public Pair(int w, int b) {
            weight = w;
            y = b;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int nodes = s.nextInt();
        int edges = s.nextInt();
        Map<Integer, List<Pair>> g = new HashMap<>();
        for (int i = 0; i < edges; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            int w = s.nextInt();
            g.putIfAbsent(a, new ArrayList<>());
            g.putIfAbsent(b, new ArrayList<>());
            g.get(a).add(new Pair(w, b));
            g.get(b).add(new Pair(w, a));
        }

        int minimumCost = prim(1, g);
        System.out.println(minimumCost);
    }

    private static int prim(int x, Map<Integer, List<Pair>> g) {
        boolean[] visited = new boolean[10005];
        PriorityQueue<Pair> heap = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        heap.offer(new Pair(0, x));

        int minimumCost = 0;
        while (!heap.isEmpty()) {
            Pair p = heap.poll();
            x = p.y;
            if (visited[x]) continue;
            visited[x] = true;
            minimumCost += p.weight;

            for (int i = 0; i < g.get(x).size(); i++) {
                if (!visited[g.get(x).get(i).y]) {
                    heap.offer(g.get(x).get(i));
                }
            }
        }

        return minimumCost;
    }
}
