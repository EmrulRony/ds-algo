package algoexpert.graph.minimumPasses;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Program {

    public int minimumPassesOfMatrix(int[][] matrix) {
        // Write your code here.
        int passes = convertNegatives(matrix);
        return hasAnyNegativePosition(matrix) ? -1 : passes - 1;
    }

    private int convertNegatives(int[][] matrix) {
        int passes = 0;
        Queue<Integer[]> queue = getAllPositivePositions(matrix);
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            while (queueSize > 0) {
                Integer[] currentPosition = queue.poll();
                List<Integer[]> neighbours = getAllNeighbourPositions(currentPosition, matrix);
                neighbours.forEach(neighbourPosition -> {
                    Integer row = neighbourPosition[0];
                    Integer col = neighbourPosition[1];
                    matrix[row][col] *= -1;
                    queue.add(neighbourPosition);
                });
                queueSize--;
            }
            passes++;
        }
        return passes;
    }

    private List<Integer[]> getAllNeighbourPositions(Integer[] currentPosition, int[][] matrix) {
        List<Integer[]> neighbours = new ArrayList<>();
        Integer row = currentPosition[0];
        Integer col = currentPosition[1];
        if (row > 0 && matrix[row - 1][col] < 0) {
            neighbours.add(new Integer[]{row - 1, col});
        }
        if (col < matrix[row].length - 1 && matrix[row][col + 1] < 0) {
            neighbours.add(new Integer[]{row, col + 1});
        }
        if (row < matrix.length - 1 && matrix[row + 1][col] < 0) {
            neighbours.add(new Integer[]{row + 1, col});
        }
        if (col > 0 && matrix[row][col - 1] < 0) {
            neighbours.add(new Integer[]{row, col - 1});
        }
        return neighbours;
    }

    private Queue<Integer[]> getAllPositivePositions(int[][] matrix) {
        Queue<Integer[]> queue = new LinkedList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int currentPositionValue = matrix[row][col];
                if (currentPositionValue > 0) {
                    queue.add(new Integer[]{row, col});
                }
            }
        }
        return queue;
    }

    private boolean hasAnyNegativePosition(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                if (val < 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
