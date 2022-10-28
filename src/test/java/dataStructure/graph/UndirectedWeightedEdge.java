package dataStructure.graph;

public class UndirectedWeightedEdge {
    private GraphNode firstNode;
    private GraphNode secondNode;
    private int weight;

    public UndirectedWeightedEdge(GraphNode firstNode, GraphNode secondNode, int weight) {
        this.firstNode = firstNode;
        this.secondNode = secondNode;
        this.weight = weight;
    }

    public GraphNode getFirstNode() {
        return firstNode;
    }

    public void setFirstNode(GraphNode firstNode) {
        this.firstNode = firstNode;
    }

    public GraphNode getSecondNode() {
        return secondNode;
    }

    public void setSecondNode(GraphNode secondNode) {
        this.secondNode = secondNode;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
