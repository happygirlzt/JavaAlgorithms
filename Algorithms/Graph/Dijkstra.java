/**
 * Created 16 May 2019 by happygirlzt
 *
 * Single Source Shortest Path, Dijkstra's Algorithm
 *
 */

class Dijkstra {
    static class Pair {
        int weight;
        int y;
        public Pair(int w, int y) {
            weight = w;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();

        Map<Integer, List<Pair>> g = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            int w = s.nextInt();

            g.putIfAbsent(a, new ArrayList<>());
            g.putIfAbsent(b, new ArrayList<>());
            g.get(a).add(new Pair(w, b));
            g.get(b).add(new Pair(w, a));
        }

        int[] res = new int[n - 1];
        dijsktra(g, res);
        System.out.println(Arrays.toString(res));
    }

    private static void dijkstra(Map<Integer, List<Pair>> g, int[] res) {
        boolean[] visited = new boolean[100005];
        int[] dist = new int[100005];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        PriorityQueue<Pair> heap = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        heap.offer(new Pair(0, 1));

        int index = 0;
        while (!heap.isEmpty()) {
            Pair p = heap.poll();
            int x = p.y;
            int weight = p.weight;
            if (visited[x]) continue;
            visited[x] = true;

            // res.add(weight);
            res[index++] = weight;
            for (int i = 0; i < g.get(x).size(); i++) {
                int y = g.get(x).get(i).y;
                int w = g.get(x).get(i).weight;

                if (dist[x] + w < dist[y]) {
                    dist[y] = dist[x] + w;
                    heap.offer(new Pair(dist[y], y));
                }
            }
        }
    }
}
