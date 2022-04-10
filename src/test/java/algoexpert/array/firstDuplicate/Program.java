package algoexpert.array.firstDuplicate;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Program {
    // time -> O(n), space -> O(n)
    public int firstDuplicateValueNonOptimalSol(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (Integer element : array) {
            if (set.contains(element)) {
                return element;
            }
            set.add(element);
        }
        return -1;
    }

    // time -> O(n), space -> O(1)
    public int firstDuplicateValue(int[] array) {
        // eq => index = abs(element) - 1;
        for (Integer element : array) {
            int index = Math.abs(element) - 1;
            if (array[index] < 0) {
                return Math.abs(element);
            }
            array[index] *= -1;
        }
        return -1;
    }


    @Test
    public void TestCase1() {
        var input = new int[] {2, 1, 5, 2, 3, 3, 4};
        var expected = 2;
        var actual = new Program().firstDuplicateValue(input);
        assertEquals(expected, actual);
    }

    @Test
    public void TestCase2() {
        var input = new int[] {2, 1, 5, 3, 3, 2, 4};
        var expected = 3;
        var actual = new Program().firstDuplicateValue(input);
        assertEquals(expected, actual);
    }
}
