package dataStructure.graph;

import java.util.ArrayList;
import java.util.HashMap;

public class GraphNode implements Comparable<GraphNode>{
    private String name;
    private int index;
    private ArrayList<GraphNode> neighbours = new ArrayList<>();
    private HashMap<GraphNode, Integer> weightMap = new HashMap<>();
    private boolean isVisited;
    private int distance;
    private GraphNode parentNode;

    public GraphNode(String name) {
        this.name = name;
    }

    public GraphNode(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public HashMap<GraphNode, Integer> getWeightMap() {
        return weightMap;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public ArrayList<GraphNode> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(ArrayList<GraphNode> neighbours) {
        this.neighbours = neighbours;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public GraphNode getParentNode() {
        return parentNode;
    }

    public void setParentNode(GraphNode parentNode) {
        this.parentNode = parentNode;
    }

    @Override
    public int compareTo(GraphNode node) {
        return this.distance - node.distance;
    }
}
