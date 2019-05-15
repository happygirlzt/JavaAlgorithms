/**
 * Created on 15 May 2019 by happygirlzt
 *
 * Minimum Spanning Tree, Kruskal’s Algorithm
 *
 * Credit to https://www.hackerearth.com/zh/practice/algorithms/graphs/minimum-spanning-tree/tutorial/
 *
 */

class MST_Kruskal {
    class Edge {
        int weight;
        int x;
        int y;
        public Pair(int w, int a, int b) {
            weight = w;
            x = a;
            y = b;
        }
    }

    class DSU {
        int[] root;
        int[] size;

        public DSU(int n) {
            root = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                root[i] = i;
            }

            Arrays.fill(size, 1);
        }

        public int find(int x) {
            if (root[x] != x) {
                root[x] = find(root[x]);
            }

            return root[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }

            if (size[rootX] < size[rootY]) {
                root[rootX] = rootY;
                size[rootY]++;
            } else {
                root[rootY] = rootX;
                size[rootX]++;
            }
        }
    }

    private static int kruskal(Edge[] edges) {
        DSU dsu = new DSU(10005);

        int minimumCost = 0;
        for (Edge e : edges) {
            int x = e.x;
            int y = e.y;
            int weight = e.weight;

            if (dsu.find(x) != dsu.find(y)) {
                minimumCost += weight;
                dsu.union(x, y);
            }
        }

        return minimimCost;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();

        Edge[] edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            int w = s.nextInt();

            edges[i] = new Edge(w, a, b);
        }

        int minimumCost = kruskal(edges);
        System.out.println(minimumCost);
    }
}
