package dataStructure.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Prims {
    private final List<GraphNode> nodeList;

    public Prims(List<GraphNode> nodeList) {
        this.nodeList = nodeList;
    }

    public int prims(GraphNode sourceNode) {
        sourceNode.setDistance(0);
        PriorityQueue<GraphNode> priorityQueue = new PriorityQueue<>();
        priorityQueue.addAll(nodeList);

        while (!priorityQueue.isEmpty()) {
            GraphNode currentNode = priorityQueue.remove();
            currentNode.getNeighbours().forEach(neighbourNode -> {
                if (priorityQueue.contains(neighbourNode) && neighbourNode.getDistance() > currentNode.getWeightMap().get(neighbourNode)) {
                    neighbourNode.setDistance(currentNode.getWeightMap().get(neighbourNode));
                    // refresh priority queue
                    priorityQueue.remove(neighbourNode);
                    priorityQueue.add(neighbourNode);
                }
            });
        }

        return nodeList.stream()
                .map(GraphNode::getDistance)
                .reduce(0, Integer::sum);
    }

    public void addUndirectedWeightedEdge(int i, int j, int distance) {
        GraphNode firstNode = nodeList.get(i);
        GraphNode secondNode = nodeList.get(j);
        firstNode.getNeighbours().add(secondNode);
        firstNode.getWeightMap().put(secondNode, distance);
        secondNode.getNeighbours().add(firstNode);
        secondNode.getWeightMap().put(firstNode, distance);
    }

    public static void main(String[] args) {
        ArrayList<GraphNode> nodeList = new ArrayList<>();

        for(int i=0;i<5; i++) {
            nodeList.add(new GraphNode(""+(char)(65+i), Integer.MAX_VALUE));
        }
        Prims prims = new Prims(nodeList);

        prims.addUndirectedWeightedEdge(0, 1, 15); // A <--> B | 15
        prims.addUndirectedWeightedEdge(0, 2, 20); // A <--> C | 20
        prims.addUndirectedWeightedEdge(1, 2, 13); // B <--> C | 13
        prims.addUndirectedWeightedEdge(1, 3, 5);  // B <--> D | 5
        prims.addUndirectedWeightedEdge(2, 3, 10); // C <--> D | 10
        prims.addUndirectedWeightedEdge(2, 4, 6); // C <--> E | 6
        prims.addUndirectedWeightedEdge(3, 4, 8); // D <--> E | 8

        int minDistance = prims.prims(nodeList.get(0));
        System.out.println("Minimum distance " + minDistance);
    }
}
