package dataStructure.graph;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {
    List<GraphNode> nodes;

    public FloydWarshall(List<GraphNode> nodes) {
        this.nodes = nodes;
    }

    public void floydWarshall() {
        int size = nodes.size();
        int[][] distance = new int[size][size];
        for (int i = 0; i < size; i++) {
            GraphNode firstNode = nodes.get(i);
            for (int j = 0; j < size; j++) {
                GraphNode secondNode = nodes.get(j);
                if (i == j) {
                    distance[i][j] = 0;
                } else if (firstNode.getWeightMap().containsKey(secondNode)) {
                    distance[i][j] = firstNode.getWeightMap().get(secondNode);
                } else {
                    distance[i][j] = Integer.MAX_VALUE / 10;
                }
            }
        }

        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }

        for (int i = 0; i < size; i++) {
            System.out.print("Printing distance list for node "+nodes.get(i).getName()+": ");
            for (int j = 0; j < size; j++) {
                System.out.print(distance[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void addWeightedEdge(int i, int j, int d) {
        GraphNode firstNode = nodes.get(i);
        GraphNode secondNode = nodes.get(j);
        firstNode.getNeighbours().add(secondNode);
        firstNode.getWeightMap().put(secondNode, d);
    }

    public static void main(String[] args) {
        ArrayList<GraphNode> nodeList = new ArrayList<>();

        //Create 4 Vertices: A,B,C,D
        for (int i = 0; i < 4; i++) {
            nodeList.add(new GraphNode("" + (char) (65 + i)));
        }

        FloydWarshall graph = new FloydWarshall(nodeList);
        graph.addWeightedEdge(0, 3, 1);// Add A-> D , weight 1
        graph.addWeightedEdge(0, 1, 8);// Add A-> B , weight 8
        graph.addWeightedEdge(1, 2, 1);// Add B-> C , weight 1
        graph.addWeightedEdge(2, 0, 4);// Add C-> A , weight 4
        graph.addWeightedEdge(3, 1, 2);// Add D-> B , weight 2
        graph.addWeightedEdge(3, 2, 9);// Add D-> C , weight 9

        System.out.println("Printing Floyd-Warshall from each source:");
        graph.floydWarshall();
    }
}

//    A  B  C  D
// A[ 0  3  4  1]
// B[ 5  0  1  6]
// C[ 4  7  0  5]
// D[ 7  2  3  0]