package dataStructure.graph;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    List<GraphNode> nodes;

    public DisjointSet() {
        nodes = new ArrayList<>();
    }

    public void drive(List<GraphNode> nodeList) {
        prepareSet(nodeList);
        for (int i = 0; i < nodeList.size() - 1; i++) {
            GraphNode firstNode = nodeList.get(i);
            GraphNode secondNode = nodeList.get(i + 1);
            if (firstNode.getSet() != secondNode.getSet()) {
                union(firstNode, secondNode);
            }
        }
    }

    public void union(GraphNode firstNode, GraphNode secondNode) {
        DisjointSet firstSet = firstNode.getSet();
        DisjointSet secondSet = secondNode.getSet();
        if (firstSet.getNodes().size() > secondSet.getNodes().size()) {
            for (GraphNode graphNode : secondSet.getNodes()) {
                firstSet.getNodes().add(graphNode);
                graphNode.setSet(firstSet);
            }
        } else {
            for (GraphNode graphNode : firstSet.getNodes()) {
                secondSet.getNodes().add(graphNode);
                graphNode.setSet(secondSet);
            }
        }
    }

    public void prepareSet(List<GraphNode> nodeList) {
        nodeList.forEach(node -> {
            DisjointSet set = new DisjointSet();
            set.getNodes().add(node);
            node.setSet(set);
        });
    }

    public List<GraphNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<GraphNode> nodes) {
        this.nodes = nodes;
    }
}
