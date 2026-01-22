import java.util.*;

public class DFS {
    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        int n = 12;
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(2).add(7);
        graph.get(2).add(8);
        graph.get(3).add(11);
        graph.get(3).add(4);
        boolean[] visited = new boolean[n];for (int i = 0; i < graph.size(); i++) {
            if (graph.get(i) != null && !graph.get(i).isEmpty()) {
                System.out.print(i + " -> ");
                for (int neighbor : graph.get(i)) {
                    System.out.print(neighbor + " ");
                }
                System.out.println();
            }
        }
        System.out.println("DFS Traversal");
        dfsMethod(1, visited, graph);
    }

    static void dfsMethod(int node, boolean[] visited, List<List<Integer>> graph) {
        if (node >= visited.length || node < 0) {
            return;
        }
        visited[node] = true;
        System.out.print(node + " ");
        for (int child : graph.get(node)) {
            if (child < visited.length && child >= 0 && !visited[child]) {
                dfsMethod(child, visited, graph);
            }
        }
    }
}

