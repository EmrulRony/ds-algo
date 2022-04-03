package algoexpert.array.longestPeak;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Program {
    public static int longestPeak(int[] array) {
        // Write your code here
        int index = 1;
        int longestLength = 0;
        while (index < array.length - 1) {
            boolean isPeak = array[index - 1] < array[index] && array[index] > array[index + 1];
            if (!isPeak) {
                index++;
                continue;
            }
            int leftIndex = index - 2;
            while (leftIndex >= 0 && array[leftIndex] < array[leftIndex + 1]) {
                leftIndex--;
            }
            int rightIndex = index + 2;
            while (rightIndex < array.length && array[rightIndex - 1] > array[rightIndex]) {
                rightIndex++;
            }
            int currentLength = rightIndex - leftIndex - 1;
            if (currentLength > longestLength) {
                longestLength = currentLength;
            }
            index = rightIndex;
        }
            return longestLength;
    }

    @Test
    public void TestCase1() {
        var input = new int[] {1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
        var expected = 6;
        var actual = Program.longestPeak(input);
        assertEquals(expected, actual);
    }
}
