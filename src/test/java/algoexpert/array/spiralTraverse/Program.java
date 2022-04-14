package algoexpert.array.spiralTraverse;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Program {
    public static List<Integer> spiralTraverse(int[][] array) {
        // Write your code here.
        List<Integer> result = new ArrayList<>();
        int startingRow = 0;
        int startingCol = 0;
        int endingRow = array.length - 1;
        int endingCol = array[0].length - 1;

        while (startingRow <= endingRow && startingCol <= endingCol) {
            for (int col = startingCol; col <= endingCol; col++) {
                result.add(array[startingRow] [col]);
            }
            for(int row = startingRow + 1; row <= endingRow; row++) {
                result.add(array[row] [endingCol]);
            }
            for(int col = endingCol - 1; col >= startingCol; col--) {
                if (startingRow == endingRow) break;
                result.add(array[endingRow] [col]);
            }
            for(int row = endingRow - 1; row > startingRow; row--) {
                if (startingCol == endingCol) break;
                result.add(array[row] [startingCol]);
            }
            startingRow++;
            startingCol++;
            endingRow--;
            endingCol--;
        }
        return result;
    }

    @Test
    public void TestCase1() {
        var input =
                new int[][] {
                        {1, 2, 3, 4},
                        {12, 13, 14, 5},
                        {11, 16, 15, 6},
                        {10, 9, 8, 7},
                };
        var expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        var actual = Program.spiralTraverse(input);
        assertEquals(expected, actual);
    }
}
