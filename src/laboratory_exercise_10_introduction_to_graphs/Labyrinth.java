package laboratory_exercise_10_introduction_to_graphs;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;


public class Labyrinth {
    Graph graph;
    int start, end;
    Hashtable<Integer, String> hash;
    Hashtable<String, Integer> rehash;

    Labyrinth() {
        hash = new Hashtable<>();
        rehash = new Hashtable<>();
    }

    void createGraph(int rows, int columns, String[] input) {
        int numberOfNodes = 0;
        String key;
        GraphNode nodes[] = new GraphNode[rows * columns];

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                if (input[i].charAt(j) != '#') {
                    key = i + "," + j;
                    hash.put(numberOfNodes, key);
                    rehash.put(key, numberOfNodes);
                    nodes[numberOfNodes] = new GraphNode(numberOfNodes, key);

                    if (input[i].charAt(j) == 'S')
                        start = numberOfNodes;
                    if (input[i].charAt(j) == 'E')
                        end = numberOfNodes;

                    ++numberOfNodes;
                }
            }
        }

        graph = new Graph(numberOfNodes, nodes);
        int x, y;

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                if (input[i].charAt(j) != '#') {
                    if (input[i].charAt(j - 1) != '#') {
                        x = rehash.get(i + "," + j);
                        y = rehash.get(i + "," + (j - 1));
                        graph.addEdge(x, y);
                    }

                    if (input[i].charAt(j + 1) != '#') {
                        x = rehash.get(i + "," + j);
                        y = rehash.get(i + "," + (j + 1));
                        graph.addEdge(x, y);
                    }

                    if (input[i - 1].charAt(j) != '#') {
                        x = rehash.get(i + "," + j);
                        y = rehash.get((i - 1) + "," + j);
                        graph.addEdge(x, y);
                    }

                    if (input[i + 1].charAt(j) != '#') {
                        x = rehash.get(i + "," + j);
                        y = rehash.get((i + 1) + "," + j);
                        graph.addEdge(x, y);
                    }
                }
            }
        }
    }

    void findPath() {
        boolean visited[] = new boolean[graph.numberNodes];
        for (int i = 0; i < graph.numberNodes; i++)
            visited[i] = false;

        visited[start] = true;
        Stack<Integer> s = new Stack<Integer>();
        s.push(start);

        GraphNode pom;

        while (!s.isEmpty() && s.peek() != end) {
            pom = graph.adjustedMatrix[s.peek()];
            GraphNode tmp = null;
            for (int i = 0; i < pom.getNeighbors().size(); i++) {
                tmp = pom.getNeighbors().get(i);
                if (!visited[tmp.getIndex()])
                    break;
            }
            if (tmp != null && !visited[tmp.getIndex()]) {
                visited[tmp.getIndex()] = true;
                s.push(tmp.getIndex());
            } else
                s.pop();
        }

        if (s.isEmpty())
            System.out.println("Nema reshenie");
        else {
            Stack<Integer> os = new Stack<Integer>();
            while (!s.isEmpty())
                os.push(s.pop());
            while (!os.isEmpty())
                System.out.println(hash.get(os.pop()));
        }
    }

    @Override
    public String toString() {
        return graph.toString();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Labyrinth lavirint = new Labyrinth();
        String line = scan.nextLine();
        String parts[] = line.split(",");

        int rows = Integer.parseInt(parts[0]);
        int columns = Integer.parseInt(parts[1]);

        String input[] = new String[rows];

        for (int i = 0; i < rows; ++i) {
            input[i] = scan.nextLine();
        }

        lavirint.createGraph(rows, columns, input);
        lavirint.findPath();
    }
}

class GraphNode {
    private int index;
    private String info;
    private LinkedList<GraphNode> neighbors;

    public GraphNode(int index, String info) {
        this.index = index;
        this.info = info;
        neighbors = new LinkedList<GraphNode>();
    }

    boolean containsNeighbor(GraphNode o) {
        return neighbors.contains(o);
    }

    void addNeighbor(GraphNode o) {
        neighbors.add(o);
    }

    void removeNeighbor(GraphNode o) {
        if (neighbors.contains(o))
            neighbors.remove(o);
    }

    @Override
    public boolean equals(Object obj) {
        @SuppressWarnings("unchecked")
        GraphNode pom = (GraphNode) obj;
        return (pom.info.equals(this.info));
    }

    @Override
    public String toString() {
        return index + " " + info;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public LinkedList<GraphNode> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(LinkedList<GraphNode> neighbors) {
        this.neighbors = neighbors;
    }
}

class Graph {
    int numberNodes;
    GraphNode adjustedMatrix[];

    @SuppressWarnings("unchecked")
    public Graph(int numberNodes, GraphNode[] list) {
        this.numberNodes = numberNodes;
        adjustedMatrix = new GraphNode[numberNodes];

        for (int i = 0; i < numberNodes; ++i)
            adjustedMatrix[i] = list[i];
    }

    int adjacent(int x, int y) {
        return (adjustedMatrix[x].containsNeighbor(adjustedMatrix[y])) ? 1 : 0;
    }

    void addEdge(int x, int y) {
        if (!adjustedMatrix[x].containsNeighbor(adjustedMatrix[y])) {
            adjustedMatrix[x].addNeighbor(adjustedMatrix[y]);
        }
        if (!adjustedMatrix[y].containsNeighbor(adjustedMatrix[x])) {
            adjustedMatrix[y].addNeighbor(adjustedMatrix[x]);
        }
    }

    void deleteEdge(int x, int y) {
        adjustedMatrix[x].removeNeighbor(adjustedMatrix[y]);
        adjustedMatrix[y].removeNeighbor(adjustedMatrix[x]);
    }

    @Override
    public String toString() {
        String ret = new String();

        for (int i = 0; i < this.numberNodes; i++)
            ret += adjustedMatrix[i] + "\n";

        return ret;
    }
}