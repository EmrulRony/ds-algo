package dataStructure.graph;

import java.util.ArrayList;
import java.util.List;

public class Kruskal {
    List<GraphNode> nodes;
    List<UndirectedWeightedEdge> edges;

    public Kruskal(List<GraphNode> nodes) {
        this.nodes = nodes;
        edges = new ArrayList<>();
    }

    public int kruskal() {
        DisjointSet disjointSet = new DisjointSet();
        disjointSet.prepareSet(nodes);
        edges.sort((edge1, edge2) -> edge1.getWeight() - edge2.getWeight());
        int count = 0;
        for (UndirectedWeightedEdge edge : edges) {
            GraphNode firstNode = edge.getFirstNode();
            GraphNode secondNode = edge.getSecondNode();
            if (firstNode.getSet() != secondNode.getSet()) {
                disjointSet.union(firstNode, secondNode);
                count = count + edge.getWeight();
            }
        }
        return count;
    }

    public void addUndirectedWeightedEdge(int i, int j, int weight) {
        GraphNode firstNode = nodes.get(i);
        GraphNode secondNode = nodes.get(j);
        UndirectedWeightedEdge edge = new UndirectedWeightedEdge(firstNode, secondNode, weight);
        firstNode.getNeighbours().add(secondNode);
        firstNode.getWeightMap().put(secondNode, weight);
        secondNode.getNeighbours().add(firstNode);
        secondNode.getWeightMap().put(firstNode, weight);
        edges.add(edge);
    }

    public static void main(String[] args) {
        ArrayList<GraphNode> nodeList = new ArrayList<>();

        for(int i=0;i<5; i++) {
            nodeList.add(new GraphNode(""+(char)(65+i)));
        }
        Kruskal graph = new Kruskal(nodeList);

        graph.addUndirectedWeightedEdge(0, 1, 15); // A <--> B | 15
        graph.addUndirectedWeightedEdge(0, 2, 20); // A <--> C | 20
        graph.addUndirectedWeightedEdge(1, 2, 13); // B <--> C | 13
        graph.addUndirectedWeightedEdge(1, 3, 5);  // B <--> D | 5
        graph.addUndirectedWeightedEdge(2, 3, 10); // C <--> D | 10
        graph.addUndirectedWeightedEdge(2, 4, 6); // C <--> E | 6
        graph.addUndirectedWeightedEdge(3, 4, 8); // D <--> E | 8

        int minDistance = graph.kruskal();
        System.out.println("Minimum distance " + minDistance);
    }
}
