package dataStructure.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
    private List<GraphNode> nodeList;

    public Dijkstra(List<GraphNode> nodes) {
        this.nodeList = nodes;
    }

    public void insertDirectedWeightedEdge(int i, int j, int distance) {
        GraphNode firstNode = nodeList.get(i);
        GraphNode secondNode = nodeList.get(j);
        firstNode.getNeighbours().add(secondNode);
        firstNode.getWeightMap().put(secondNode, distance);
    }

    public void dijkstra(GraphNode sourceNode) {
        sourceNode.setDistance(0);
        PriorityQueue<GraphNode> queue = new PriorityQueue<>();
        queue.addAll(nodeList);
        while (!queue.isEmpty()) {
            GraphNode currentNode = queue.remove();
            currentNode.getNeighbours().forEach(neighbourNode -> {
                int distanceToNeighbour = currentNode.getDistance() + currentNode.getWeightMap().get(neighbourNode);
                if (distanceToNeighbour < neighbourNode.getDistance()) {
                    neighbourNode.setDistance(distanceToNeighbour);
                    neighbourNode.setParentNode(currentNode);
                    // refreshing queue
                    queue.remove(neighbourNode);
                    queue.add(neighbourNode);
                }
            });
        }
    }

    public void printDijkstra() {
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
            nodeList.add(new GraphNode(String.valueOf((char) (65+i)), Integer.MAX_VALUE));
        }
        Dijkstra dijkstra = new Dijkstra(nodeList);
        //A -> B -> C -> D -> E;
        //0 -> 1 -> 2 -> 3 -> 4
        dijkstra.insertDirectedWeightedEdge(4, 1, 4); // E -> B | 4
        dijkstra.insertDirectedWeightedEdge(4, 3, 2); // E -> D | 2
        dijkstra.insertDirectedWeightedEdge(1, 0, 3); // B -> A | 3
        dijkstra.insertDirectedWeightedEdge(2, 3, 2); // C -> D | 2
        dijkstra.insertDirectedWeightedEdge(3, 1, 1); // D -> B | 1
        dijkstra.insertDirectedWeightedEdge(3, 2, 1); // D -> C | 2
        dijkstra.insertDirectedWeightedEdge(0, 2, 6); // A -> C | 6
        dijkstra.insertDirectedWeightedEdge(0, 3, 6); // A -> D | 6

        dijkstra.dijkstra(nodeList.get(4));
        dijkstra.printDijkstra();
    }

}
