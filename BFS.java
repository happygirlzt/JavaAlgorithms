import java.util.*;

public class BFS {
    private Queue<Integer> queue;

    public BFS() {
        queue = new LinkedList<Integer>();
    }

    public void bfs(int[][] adjacency_matrix, int source) {
        int number_of_nodes = adjacency_matrix[source].length - 1;

        int[] visited = new int[number_of_nodes + 1];
        int i, element;

        visited[source] = 1;
        queue.add(source);

        while(!queue.isEmpty()) {
            element = queue.remove();
            i = element;
            System.out.print(i + "\t");
            while (i <= number_of_nodes) {
                if (adjacency_matrix[element][i] == 1 && visited[i] == 1) {

                    queue.add(i);
                    visited[i] = 1;
                }
                i++;
            }
        }
    }

    public static void main(String[] agrs) {
    }
}
