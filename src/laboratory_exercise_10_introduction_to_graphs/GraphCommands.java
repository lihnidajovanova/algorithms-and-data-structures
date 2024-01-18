package laboratory_exercise_10_introduction_to_graphs;

import java.util.*;

public class GraphCommands {

    static class Graph {
        int vertices;
        List<Integer>[] adjacencyList;

        public Graph(int vertices) {
            this.vertices = vertices;
            this.adjacencyList = new ArrayList[vertices];
            for (int i = 0; i < vertices; i++) {
                this.adjacencyList[i] = new ArrayList<>();
            }
        }

        public void addEdge(int v1, int v2) {
            adjacencyList[v1].add(v2);
            adjacencyList[v2].add(v1);
        }

        public void removeEdge(int v1, int v2) {
            adjacencyList[v1].remove(Integer.valueOf(v2));
            adjacencyList[v2].remove(Integer.valueOf(v1));
        }

        public boolean areAdjacent(int v1, int v2) {
            return adjacencyList[v1].contains(v2);
        }

        public void printGraph() {
            for (int i = 0; i < vertices; i++) {
                System.out.print(i + ": ");
                for (int neighbor : adjacencyList[i]) {
                    System.out.print(neighbor + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCommands = Integer.parseInt(scanner.nextLine());
        Graph graph = null;

        for (int i = 0; i < numCommands; i++) {
            String[] command = scanner.nextLine().split(" ");

            switch (command[0]) {
                case "CREATE":
                    int numVertices = Integer.parseInt(command[1]);
                    graph = new Graph(numVertices);
                    break;

                case "ADDEDGE":
                    int v1 = Integer.parseInt(command[1]);
                    int v2 = Integer.parseInt(command[2]);
                    graph.addEdge(v1, v2);
                    break;

                case "DELETEEDGE":
                    int deleteV1 = Integer.parseInt(command[1]);
                    int deleteV2 = Integer.parseInt(command[2]);
                    graph.removeEdge(deleteV1, deleteV2);
                    break;

                case "ADJACENT":
                    int adjV1 = Integer.parseInt(command[1]);
                    int adjV2 = Integer.parseInt(command[2]);
                    System.out.println(graph.areAdjacent(adjV1, adjV2));
                    break;

                case "PRINTGRAPH":
                    graph.printGraph();
                    break;
            }
        }

        scanner.close();
    }
}