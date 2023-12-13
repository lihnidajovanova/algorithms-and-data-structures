package auditory_exercises_11_graphs_algorithms.lista_tezinski_nenasocen;

public class GraphNodeNeighbour<E> {
    GraphNode<E> node;
    float weight;

    public GraphNodeNeighbour(GraphNode<E> node, float weight) {
        this.node = node;
        this.weight = weight;
    }

    public GraphNodeNeighbour(GraphNode<E> node) {
        this.node = node;
        this.weight = 0;
    }

    @Override
    public boolean equals(Object obj) {
        @SuppressWarnings("unchecked")
        GraphNodeNeighbour<E> pom = (GraphNodeNeighbour<E>) obj;
        return pom.node.equals(this.node);
    }
}