package dataStructure.graph;

import java.util.*;

public class GraphDFS {
    List<GraphNode> nodes = new ArrayList<>();

    public GraphDFS(List<GraphNode> nodes) {
        this.nodes = nodes;
    }

    public void bfs(GraphNode startingNode) {
        Stack<GraphNode> stack = new Stack<>();
        stack.add(startingNode);
        while (!stack.isEmpty()) {
            GraphNode currentNode = stack.pop();
            System.out.println(currentNode.getName());
            currentNode.setVisited(true);
            for (GraphNode neighbourNode : currentNode.getNeighbours()) {
                if (!neighbourNode.isVisited()) {
                    stack.add(neighbourNode);
                    neighbourNode.setVisited(true);
                }
            }
        }
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

        GraphDFS graph = new GraphDFS(graphNodes);

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
