package dataStructure.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {
    List<GraphNode> nodes;

    public TopologicalSort(List<GraphNode> nodes) {
        this.nodes = nodes;
    }

    public void topologicalSort() {
        Stack<GraphNode> stack = new Stack<>();
        nodes.forEach(node -> {
            if (!node.isVisited()) {
                topologicalSort(node, stack);
            }
        });
        while (!stack.isEmpty()) {
            GraphNode currentNode = stack.pop();
            System.out.println(currentNode.getName());
        }
    }

    private void topologicalSort(GraphNode node, Stack<GraphNode> stack) {
        node.getNeighbours().forEach(neighborNode -> {
            if (!neighborNode.isVisited()) {
                topologicalSort(neighborNode, stack);
            }
        });
        node.setVisited(true);
        stack.add(node);
    }

    public void addDirectedEdge(int i, int j) {
        GraphNode firstNode = nodes.get(i - 1);
        GraphNode secondNode = nodes.get(j - 1);
        firstNode.getNeighbours().add(secondNode);
    }

    public static void main(String[] args) {
        List<GraphNode> graphNodes = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            graphNodes.add(new GraphNode("V" + i));
        }
        TopologicalSort graph = new TopologicalSort(graphNodes);
        graph.addDirectedEdge(1, 3);
        graph.addDirectedEdge(2, 3);
        graph.addDirectedEdge(2, 4);
        graph.addDirectedEdge(3, 5);
        graph.addDirectedEdge(4, 6);
        graph.addDirectedEdge(5, 8);
        graph.addDirectedEdge(5, 6);
        graph.addDirectedEdge(6, 7);

        graph.topologicalSort();
    }
}
