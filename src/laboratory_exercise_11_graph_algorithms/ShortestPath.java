/*
package laboratory_exercise_11_graph_algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge {
    private int fromVertex, toVertex;
    private float weight;

    public Edge(int from, int to, float weight) {
        this.fromVertex = from;
        this.toVertex = to;
        this.weight = weight;
    }

    public int getFrom() {
        return this.fromVertex;
    }

    public int getTo() {
        return this.toVertex;
    }

    public float getWeight() {
        return this.weight;
    }
}

class CitiesGraph extends Graph<String> {
    public CitiesGraph(int num_nodes) {
        super(num_nodes);
    }

    public CitiesGraph(int num_nodes, String[] list) {
        super(num_nodes, list);
    }

    public int getIndexFromValue(String val) {
        for (int i = 0; i < this.adjList.length; i++) {
            if (adjList[i].getInfo().equals(val)) return i;
        }
        return -1;
    }
}

public class Cities {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        CitiesGraph graph = new CitiesGraph(N);

        int M = Integer.parseInt(bf.readLine());
        for (int i = 0; i < M; i++) {
            String[] line = bf.readLine().split("\\s+");
            graph.adjList[Integer.parseInt(line[0])].setInfo(line[1]);
            graph.adjList[Integer.parseInt(line[2])].setInfo(line[3]);
            graph.addEdge(Integer.parseInt(line[0]), Integer.parseInt(line[2]), Float.parseFloat(line[4]));
        }

        String fromCity = bf.readLine();
        String toCity = bf.readLine();

        int from = graph.getIndexFromValue(fromCity);
        int to = graph.getIndexFromValue(toCity);

        int[] path = new int[N];
        float length = graph.dijkstra(from, path)[to];

        Stack<Integer> forwardPath = getPath(graph, from, to, path);
        Stack<Integer> backwardPath = getPath(graph, to, from, path);

        printPath(graph, forwardPath);
        printPath(graph, backwardPath);
        System.out.println(length);
    }

    private static Stack<Integer> getPath(CitiesGraph graph, int start, int end, int[] path) {
        Stack<Integer> stack = new Stack<>();
        int curr = end;
        while (curr != start) {
            stack.push(curr);
            curr = path[curr];
        }
        stack.push(start);
        return stack;
    }

    private static void printPath(CitiesGraph graph, Stack<Integer> path) {
        while (!path.isEmpty()) {
            System.out.print(graph.adjList[path.pop()].getInfo() + " ");
        }
        System.out.println();
    }
}*/
