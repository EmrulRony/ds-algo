package algoexpert.array.smallestDifference;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class Program {
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        // Write your code here.
        int currentDiff = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;
        int[] minDiffArr = new int[2];
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int pointerOne = 0;
        int pointerTwo = 0;
        while (pointerOne < arrayOne.length && pointerTwo < arrayTwo.length) {
            int numberOne = arrayOne[pointerOne];
            int numberTwo = arrayTwo[pointerTwo];
            if (numberOne > numberTwo) {
                currentDiff = numberOne - numberTwo;
                pointerTwo++;
            } else if (numberTwo > numberOne) {
                currentDiff = numberTwo - numberOne;
                pointerOne++;
            } else {
                return new int[]{numberOne, numberTwo};
            }
            if (currentDiff < minDiff) {
                minDiff = currentDiff;
                minDiffArr = new int[]{numberOne, numberTwo};
            }
        }
        return minDiffArr;
    }

    @Test
    public void TestCase1() {
        int[] expected = {28, 26};
        assertArrayEquals(Program.smallestDifference(
                new int[]{-1, 5, 10, 20, 28, 3}, new int[]{26, 134, 135, 15, 17}), expected);
    }
}
