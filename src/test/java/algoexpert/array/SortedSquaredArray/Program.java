package algoexpert.array.SortedSquaredArray;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Program {

    public int[] sortedSquaredArray(int[] array) {
        // Write your code here.
        int[] result = new int[array.length];
        int minValPointer = 0;
        int maxValPointer = array.length - 1;
        for (int i = maxValPointer; i >= 0; i--) {
            if (Math.abs(array[minValPointer]) > array[maxValPointer]) {
                result[i] = array[minValPointer] * array[minValPointer];
                minValPointer++;
            } else {
                result[i] = array[maxValPointer] * array[maxValPointer];
                maxValPointer--;
            }
        }
        return result;
    }

    @Test
    public void test() {
        var input = new int[] {1, 2, 3, 5, 6, 8, 9};
        var expected = new int[] {1, 4, 9, 25, 36, 64, 81};
        var actual = new Program().sortedSquaredArray(input);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }
}