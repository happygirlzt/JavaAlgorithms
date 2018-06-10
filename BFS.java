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
        int number_nodes, source;
        Scanner scanner = null;

        try {
            System.out.println("Enter the number of nodes in the graph");
            scanner = new Scanner(System.in);
            number_nodes = scanner.nextInt();

            int adjacency_matirx[][] = new int[number_nodes + 1][number_nodes + 1];
            System.out.println("Enter the adjacency matrix");
            for (int i = 1; i <= number_nodes; i++)
                for (int j = 1; j <= number_nodes; j++) {
                    adjacency_matrix[i][j] = scanner.nextIn();
                }

            System.out.println("Enter the source of this graph");
            source = scanner.
        }
    }
}
