package algoexpert.array.twoNumberSum;

import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TwoNumberSum {
    public static int[] twoNumberSum(int[] array, int targetSum) {
        // Write your code here.
        HashSet<Integer> hastTable = new HashSet<>();
        for (int x : array) {
            int y = targetSum - x;
            if (hastTable.contains(y)) {
                return new int[] {x, y};
            }
            hastTable.add(x);
        }
        return new int[] {};
    }

    @Test
    public void TestCase1() {
        int[] output = twoNumberSum(new int[] {3, 5, -4, 8, 11, 1, -1, 6}, 10);
        assertEquals(2, output.length);
        assertTrue(contains(output, -1));
        assertTrue(contains(output, 11));
    }

    public boolean contains(int[] output, int val) {
        for (var el : output) {
            if (el == val) return true;
        }
        return false;
    }

}
