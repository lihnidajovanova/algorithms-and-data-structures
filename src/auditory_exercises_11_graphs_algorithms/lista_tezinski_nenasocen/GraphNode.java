package auditory_exercises_11_graphs_algorithms.lista_tezinski_nenasocen;

import java.util.Iterator;
import java.util.LinkedList;

public class GraphNode<E> {
    private int index; // index (reden broj) na temeto vo grafot
    private E info;
    private LinkedList<GraphNodeNeighbour<E>> neighbors;

    public GraphNode(int index, E info) {
        this.index = index;
        this.info = info;
        neighbors = new LinkedList<GraphNodeNeighbour<E>>();
    }

    public boolean containsNeighbor(GraphNode<E> o) {
        GraphNodeNeighbour<E> pom = new GraphNodeNeighbour<E>(o, 0);
        return neighbors.contains(pom);
    }

    public void addNeighbor(GraphNode<E> o, float weight) {
        GraphNodeNeighbour<E> pom = new GraphNodeNeighbour<E>(o, weight);
        neighbors.add(pom);
    }

    public void removeNeighbor(GraphNode<E> o) {
        GraphNodeNeighbour<E> pom = new GraphNodeNeighbour<E>(o, 0);
        if (neighbors.contains(pom))
            neighbors.remove(pom);
    }

    @Override
    public String toString() {
        String ret = "INFO:" + info + " SOSEDI:";
        for (int i = 0; i < neighbors.size(); i++)
            ret += "(" + neighbors.get(i).node.info + "," + neighbors.get(i).weight + ") ";
        return ret;

    }

    public void updateNeighborWeight(GraphNode<E> o, float weight) {
        Iterator<GraphNodeNeighbour<E>> i = neighbors.iterator();
        while (i.hasNext()) {
            GraphNodeNeighbour<E> pom = i.next();
            if (pom.node.equals(o))
                pom.weight = weight;
        }
    }

    @Override
    public boolean equals(Object obj) {
        @SuppressWarnings("unchecked")
        GraphNode<E> pom = (GraphNode<E>) obj;
        return (pom.info.equals(this.info));
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public E getInfo() {
        return info;
    }

    public void setInfo(E info) {
        this.info = info;
    }

    public LinkedList<GraphNodeNeighbour<E>> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(LinkedList<GraphNodeNeighbour<E>> neighbors) {
        this.neighbors = neighbors;
    }
}