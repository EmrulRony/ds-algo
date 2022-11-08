package algoexpert.graph.removeIsland;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Stack;

public class Program {

    public int[][] removeIslands(int[][] matrix) {
        // Write your code here.
        boolean[][] onesConnectedToBorder = new boolean[matrix.length][matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                boolean isRowBorder = row == 0 || row == matrix.length - 1;
                boolean isColBorder = col == 0 || col == matrix[0].length - 1;
                boolean isBorder = isRowBorder || isColBorder;
                if (!isBorder || matrix[row][col] == 0) {
                    continue;
                }
                findConnectedOnesToBorder(row, col, matrix, onesConnectedToBorder);
            }
        }

        for (int row = 1; row < matrix.length - 1; row++) {
            for (int col = 1; col < matrix[0].length - 1; col++) {
                if (!onesConnectedToBorder[row][col]) {
                    matrix[row][col] = 0;
                }
            }
        }

        return matrix;
    }

    private void findConnectedOnesToBorder(int row, int col, int[][] matrix, boolean[][] onesConnectedToBorder) {
        Stack<Integer[]> stack = new Stack<>();
        stack.push(new Integer[]{row, col});
        while (!stack.isEmpty()) {
            Integer[] currentPosition = stack.pop();
            Integer currentRow = currentPosition[0];
            Integer currentCol = currentPosition[1];
            if (onesConnectedToBorder[currentRow][currentCol]) {
                continue;
            }
            onesConnectedToBorder[currentRow][currentCol] = true;
            stack.addAll(getNeighbours(currentRow, currentCol, matrix));
        }
    }

    private List<Integer[]> getNeighbours(int row, int col, int[][] matrix) {
        List<Integer[]> neighbours = new ArrayList<>();
        if (row - 1 >= 0 && matrix[row - 1][col] != 0) { // Top
            neighbours.add(new Integer[]{row - 1, col});
        }
        if (col + 1 < matrix[0].length && matrix[row][col + 1] != 0) { // Right
            neighbours.add(new Integer[]{row, col + 1});
        }
        if (row + 1 < matrix.length && matrix[row + 1][col] != 0) { // bottom
            neighbours.add(new Integer[]{row + 1, col});
        }
        if (col - 1 >= 0 && matrix[row][col - 1] != 0) { // left
            neighbours.add(new Integer[]{row, col - 1});
        }
        return neighbours;
    }
}

