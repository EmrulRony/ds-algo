package algoexpert.array.arrayOfProducts;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Program {
    public int[] arrayOfProducts(int[] array) {
        // Write your code here.
        int[] result = new int[array.length];
        int[] leftProduct = new int[array.length];
        int[] rightProduct = new int[array.length];

        leftProduct[0] = 1;
        rightProduct[array.length - 1] = 1;

        for (int i = 1; i < array.length; i++) {
            leftProduct[i] = array[i - 1] * leftProduct[i - 1];
        }

        for (int i = array.length - 2; i >= 0; i--) {
            rightProduct[i] = array[i + 1] * rightProduct[i + 1];
        }

        for (int i = 0; i < array.length; i++) {
            result[i] = leftProduct[i] * rightProduct[i];
        }
        return result;
    }

    @Test
    public void TestCase1() {
        var input = new int[] {5, 1, 4, 2};
        var expected = new int[] {8, 40, 10, 20};
        int[] actual = new Program().arrayOfProducts(input);
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < actual.length; i++) {
            assertEquals(actual[i], expected[i]);
        }
    }
}
