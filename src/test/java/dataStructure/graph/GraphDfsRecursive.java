package dataStructure.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GraphDfsRecursive {
    List<GraphNode> nodes = new ArrayList<>();

    public GraphDfsRecursive(List<GraphNode> nodes) {
        this.nodes = nodes;
    }

    public void bfs(GraphNode node) {
        node.setVisited(true);
        System.out.println(node.getName());
        node.getNeighbours().forEach(neighborNode -> {
            if (!neighborNode.isVisited()) {
                bfs(neighborNode);
            }
        });
    }

    public void addUndirectedEdge(int i, int j) {
        GraphNode firstNode = nodes.get(i - 1);
        GraphNode secondNode = nodes.get(j - 1);
        firstNode.getNeighbours().add(secondNode);
        secondNode.getNeighbours().add(firstNode);
    }

    public static void main(String[] args) {
        List<GraphNode> graphNodes = new ArrayList<>();

        for (int i = 1; i <= 7; i++) {
            graphNodes.add(new GraphNode("V" + i));
        }

        GraphDfsRecursive graph = new GraphDfsRecursive(graphNodes);

        graph.addUndirectedEdge(1, 2);
        graph.addUndirectedEdge(1, 3);
        graph.addUndirectedEdge(2, 4);
        graph.addUndirectedEdge(2, 5);
        graph.addUndirectedEdge(3, 6);
        graph.addUndirectedEdge(3, 7);

        System.out.println("Printing bfs...");
        graph.bfs(graphNodes.get(0));
    }
}
