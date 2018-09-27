/**
 * Created on 23 Sep 2018 by happygirlzt
 *
 * Graph API
 */

public class Graph {

    private final int V;  // V is number of vertices
    private List<Integer>[] adj; // Adjacency List

    // Created empty graph with v vertices
    Graph(int V) {
        this.V = V;
        adj = (List<Integer>) new ArrayList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<Integer>();
        }
    }

    // add an edge v-w
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    // vertices adjacent to v
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    /** Degree of vertex v in graph G, degree = #edges */
    public static int degree(Graph G, int v) {
        int degree = 0;
        for (int w : G.adj(v)) {
            degree += 1;
        }

        return degree;
    }
}

class DepthFirstPaths {
    // theta(V+E) time
    // theta(V) space
    private boolean[] marked;  // marked[v] is true iff v connected to s
    private int[] edgeTo;  // edgeTo[v] is previous vertex on path from s to v
    private int s;

    DepthFirstPaths(Graph G, int s) {
        ...
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }
}

// Topological Sort Implementation
class DepthFirstOrder {
    private boolean[] marked;
    private Stack<Integer> reversePostorder;

    // Perform DFS all unmarked vertices
    public DepthFirstOrder(Digraph G) {
        reversePostorder = new Stack<Integer>();
        marked = new boolean[G.V()];

        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }

        reversePostorder.push(v);
    }

    public Iterable<Integer> reversePostorder() {
        return reversePostorder;
    }
}

// BreadthFirstPaths
class BreadthFirstPaths {
    private boolean[] marked;  // marked[v] is true iff v connected to s
    private int[] edgeTo;  // edgeTo[v] is previous vertex on path from s to v

    private void bfs(Graph G, int s) {
        Queue<Integer> fringe = new Queue<>();

        // set up starting vertex
        fringe.enqueue(s);
        marked[s] = true;
        while (!fringe.isEmpty()) {
            int v = fringe.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    fringe.enqueue(w);
                    marked[w] = true;
                    edgeTo[w] = v;
                }
            }
        }
    }
}


// topological sort
class TopologicalSort {
    // a recursive function used by topological sort
    void dfs(int v, boolean[] visied, Stack stack) {
        // mark the current node as visited
        visited[v] = true;
        Integer i;

        // Recur for all the vertices adjacent to this
        // vertex
        Iterator<Integer> it = adj[v].iterator();
        while (it.hasNext()) {
            i = it.next();
            if (!visited[i]) {
                dfs(i, visited, stack);
            }
        }

        // push current vertex to stack which store res
        stack.push(new Integer(v));
    }

    void topologicalSort() {
        Stack<Integer> stack = new Stack<>();

        // mark all the vertices as not visited
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }

        // call the dfs function to store
        // topological sort starting from
        // all vertices one by one
        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                dfs(i, visited, stack);
            }
        }

        // print contents of stack
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}

// DetectCycle
class CycleDetector {
    boolean detectCycle(ArrayList[] graph, int V) {

        boolean[] visited = new boolean[V];
        boolean[] done = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!dfs(graph, i, visited, done)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(ArrayList[] graph, int v, boolean[] visited, boolean[] done) {
        // v 是索引
        visited[v] = true;

        for (int i = 0; i < graph[i].size(); i++) {
            if (!visited[i]) {
                return dfs(graph, i, visited, done);
            } else if (!done[i]) {
                return false;
            }
        }

        done[v] = true;
        return true;
    }
}
