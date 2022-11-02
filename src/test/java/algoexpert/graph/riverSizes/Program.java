package algoexpert.graph.riverSizes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Program {
    public static List<Integer> riverSizes(int[][] matrix) {
        // Write your code here.
        ArrayList<Integer> sizes = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (visited[i][j]) {
                    continue;
                }
                visitUnvisitedNode(matrix, visited, i, j, sizes);
            }
        }
        return sizes;
    }

    private static void visitUnvisitedNode(int[][] matrix, boolean[][] visited, int i, int j,
                                           ArrayList<Integer> sizes)
    {
        int riverSize = 0;
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{i, j});
        while (!queue.isEmpty()) {
            Integer[] currentNode = queue.poll();
            i = currentNode[0];
            j = currentNode[1];
            if (visited[i][j]) {
                continue;
            }
            visited[i][j] = true;
            if (matrix[i][j] == 0) {
                continue;
            }
            riverSize++;
            List<Integer[]> neighbours = getNeighbourNodes(matrix, visited, i, j);
            queue.addAll(neighbours);
        }
        if (riverSize > 0) {
            sizes.add(riverSize);
        }
    }

    private static List<Integer[]> getNeighbourNodes(int[][] matrix, boolean[][] visited, int i, int j) {
        List<Integer[]> neighbours = new ArrayList<>();
        if (i > 0 && !visited[i - 1][j]) {
            neighbours.add(new Integer[]{i - 1, j});
        }
        if (j < matrix[0].length - 1 && !visited[i][j + 1]) {
            neighbours.add(new Integer[]{i, j + 1});
        }
        if (i < matrix.length - 1 && !visited[i + 1][j]) {
            neighbours.add(new Integer[]{i + 1, j});
        }
        if (j > 0 && !visited[i][j - 1]) {
            neighbours.add(new Integer[]{i, j-1});
        }
        return neighbours;
    }
}
