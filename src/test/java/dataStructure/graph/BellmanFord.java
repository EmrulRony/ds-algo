package dataStructure.graph;

import java.util.ArrayList;
import java.util.List;

public class BellmanFord {
    private final List<GraphNode> nodeList;

    public BellmanFord(List<GraphNode> nodes) {
        this.nodeList = nodes;
    }

    public void insertDirectedWeightedEdge(int i, int j, int distance) {
        GraphNode firstNode = nodeList.get(i);
        GraphNode secondNode = nodeList.get(j);
        firstNode.getNeighbours().add(secondNode);
        firstNode.getWeightMap().put(secondNode, distance);
    }

    public void bellmanFord(GraphNode startingNode) {
        startingNode.setDistance(0);
        for (int i = 1; i < nodeList.size(); i++) {
            nodeList.forEach(node -> {
                node.getNeighbours().forEach(neighbourNode -> {
                    int distanceToNeighbor = node.getDistance() + node.getWeightMap().get(neighbourNode);
                    if (neighbourNode.getDistance() > distanceToNeighbor) {
                        neighbourNode.setDistance(distanceToNeighbor);
                        neighbourNode.setParentNode(node);
                    }
                });
            });
        }
        // Checking negative cycle
        for (GraphNode node : nodeList) {
            for (GraphNode neighbourNode : node.getNeighbours()) {
                int distanceToNeighbor = node.getDistance() + node.getWeightMap().get(neighbourNode);
                if (node.getDistance() > distanceToNeighbor) {
                    System.out.println("Negative cycle found!!");
                    break;
                }
            }
        }

        printBellmanFord();
    }

    public void printBellmanFord() {
        for (GraphNode node : nodeList) {
            System.out.println("Node: "+ node.getName() + " Distance: " + node.getDistance() + " Path: ");
            GraphNode parentNode = node.getParentNode();
            System.out.print(node.getName() + " ");
            while (parentNode != null) {
                System.out.print(parentNode.getName() + " ");
                parentNode = parentNode.getParentNode();
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        List<GraphNode> nodeList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            nodeList.add(new GraphNode(String.valueOf((char) (65+i)), Integer.MAX_VALUE / 10));
        }
        BellmanFord dijkstra = new BellmanFord(nodeList);
        //A -> B -> C -> D -> E;
        //0 -> 1 -> 2 -> 3 -> 4
        dijkstra.insertDirectedWeightedEdge(4, 1, 4); // E -> B | 4
        dijkstra.insertDirectedWeightedEdge(4, 3, 2); // E -> D | 2
        dijkstra.insertDirectedWeightedEdge(1, 0, 3); // B -> A | 3
        dijkstra.insertDirectedWeightedEdge(2, 3, 2); // C -> D | 2
        dijkstra.insertDirectedWeightedEdge(3, 1, 1); // D -> B | 1
        dijkstra.insertDirectedWeightedEdge(3, 2, 1); // D -> C | 2
        dijkstra.insertDirectedWeightedEdge(0, 2, 6); // A -> C | 6
//        dijkstra.insertDirectedWeightedEdge(0, 3, -6); // A -> D | 6
        dijkstra.insertDirectedWeightedEdge(0, 3, 6); // A -> D | 6

        dijkstra.bellmanFord(nodeList.get(4));
    }

}
