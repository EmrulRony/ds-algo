package algoexpert.array.threeNumberSum;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class Program {
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        // Write your code here.
        // eq => Sum = currentNumber + leftPointerNumber + rightPointerNumber;
        List<Integer[]> result = new ArrayList<>();
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            int currentNumber = array[i];
            int leftPointer = i + 1;
            int rightPointer = array.length - 1;
            while (leftPointer < rightPointer) {
                int sum = currentNumber + array[leftPointer] + array[rightPointer];
                if (sum == targetSum) {
                    result.add(new Integer[]{currentNumber, array[leftPointer], array[rightPointer]});
                    leftPointer++;
                    rightPointer--;
                } else if (sum < targetSum) {
                    leftPointer++;
                } else { // sum > targetSum
                    rightPointer--;
                }
            }
        }
        return result;
    }

    // Test case
    @Test
    public void TestCase1() {
        List<Integer[]> expected = new ArrayList<Integer[]>();
        expected.add(new Integer[]{-8, 2, 6});
        expected.add(new Integer[]{-8, 3, 5});
        expected.add(new Integer[]{-6, 1, 5});
        List<Integer[]> output = Program.threeNumberSum(new int[]{12, 3, 1, 2, -6, 5, -8, 6}, 0);
        assertTrue(this.compare(output, expected));
    }

    private boolean compare(List<Integer[]> triplets1, List<Integer[]> triplets2) {
        if (triplets1.size() != triplets2.size()) return false;
        for (int i = 0; i < triplets1.size(); i++) {
            if (!Arrays.equals(triplets1.get(i), triplets2.get(i))) {
                return false;
            }
        }
        return true;
    }
}
