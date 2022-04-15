package algoexpert.mergeOverlappingIntervals;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Program {
    public int[][] mergeOverlappingIntervals(int[][] intervals) {
        // Write your code here.
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        int[] currentInterval = intervals[0];
        result.add(currentInterval);
        for (int[] interval : intervals) {
            int currentIntervalStart = currentInterval[0];
            int currentIntervalEnd = currentInterval[1];
            int nextIntervalStart = interval[0];
            int nextIntervalEnd = interval[1];

            if (currentIntervalEnd >= nextIntervalStart) {
                currentInterval[1] = Math.max(currentIntervalEnd, nextIntervalEnd);
            } else {
                currentInterval = interval;
                result.add(currentInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    @Test
    public void TestCase1() {
        int[][] intervals =
                new int[][]{
                        {3, 5},
                        {1, 2},
                        {4, 7},
                        {6, 8},
                        {9, 10}
                };
        int[][] expected =
                new int[][]{
                        {1, 2},
                        {3, 8},
                        {9, 10}
                };
        int[][] actual = new Program().mergeOverlappingIntervals(intervals);
        for (int i = 0; i < actual.length; i++) {
            for (int j = 0; j < actual[i].length; j++) {
                assertEquals(expected[i][j], actual[i][j]);
            }
        }
    }
}
