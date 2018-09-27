/**
 * Created on 23 Sep 2018 by happygirlzt
 *
 * Detect cycle in a directed graph
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DetectCycleInDirectedGraph {
    class Graph {
        int vertices;
        LinkedList<Integer>[] adjList;

        // Created empty graph with v vertices
        Graph(int vertices) {
            this.vertices = vertices;
            adjList = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjList[i] = new LinkedList<>();
            }
        }
    }

    // add an edge v-w
    public void addEgde(int v, int w) {
        adjList[v].addFirst(w);
    }

    public boolean isCycle() {
        boolean visited[] = new boolean[vertices];
        boolean recursiveArr[] = new boolean[vertices];

        // do DFS from each node
        for (int i = 0; i < vertices; i++) {
            if (isCycleUnil(i, visited, recursiveArr))
                return true;
        }

        return false;
    }

    public boolean isCycleUtil(int vertex, boolean[] visited, boolean[] recursiveArr) {
        visited[vertex] = true;
        recursiveArr[vertex] = true;

        // recursive call to all the adjacent vertices
        for (int i = 0; i < adjList[vertex].size(); i++) {
            // if not already visited
            int adjVertex = adjList[vertex].get(i);
            if (!visited[adjVertex] && isCycleUtil(adjVertex, visited, recursiveArr)) {
                return true;
            } else if (recursiveArr[adjVertex]) {
                return true;
            }
        }

        recursiveArr[vertex] = false;
        return false;
    }
}
