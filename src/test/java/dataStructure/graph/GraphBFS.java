package dataStructure.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphBFS {
    List<GraphNode> nodes = new ArrayList<>();

    public GraphBFS(List<GraphNode> nodes) {
        this.nodes = nodes;
    }

    public void bfs(GraphNode startingNode) {
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(startingNode);
        while (!queue.isEmpty()) {
            GraphNode currentNode = queue.poll();
            System.out.println(currentNode.getName());
            currentNode.setVisited(true);
            for (GraphNode neighbourNode : currentNode.getNeighbours()) {
                if (!neighbourNode.isVisited()) {
                    queue.add(neighbourNode);
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

        for (int i = 2; i <= 8; i++) {
            graphNodes.add(new GraphNode("V" + i));
        }

        GraphBFS graph = new GraphBFS(graphNodes);

        graph.addUndirectedEdge(1, 2);
        graph.addUndirectedEdge(1, 3);
        graph.addUndirectedEdge(2, 5);
        graph.addUndirectedEdge(2, 7);
        graph.addUndirectedEdge(3, 4);
        graph.addUndirectedEdge(4, 6);
        graph.addUndirectedEdge(5, 6);
        graph.addUndirectedEdge(6, 7);

        System.out.println("Printing bfs...");
        graph.bfs(graphNodes.get(0));
    }
}
