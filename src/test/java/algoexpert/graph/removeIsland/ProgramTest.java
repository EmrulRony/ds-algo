package algoexpert.graph.removeIsland;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProgramTest {
    @Test
    public void TestCase1() {
        int[][] input =
                new int[][] {
                        {1, 0, 0, 0, 0, 0},
                        {0, 1, 0, 1, 1, 1},
                        {0, 0, 1, 0, 1, 0},
                        {1, 1, 0, 0, 1, 0},
                        {1, 0, 1, 1, 0, 0},
                        {1, 0, 0, 0, 0, 1},
                };
        int[][] expected =
                new int[][] {
                        {1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 1, 1},
                        {0, 0, 0, 0, 1, 0},
                        {1, 1, 0, 0, 1, 0},
                        {1, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0, 1},
                };
        algoexpert.graph.riverSizes.Program program = new algoexpert.graph.riverSizes.Program();
        int[][] actual = new Program().removeIslands(input);
        for (int i = 0; i < actual.length; i++) {
            for (int j = 0; j < actual[i].length; j++) {
                assertEquals(actual[i][j], expected[i][j]);
            }
        }
    }
}
