package algoexpert.array.nonConstructibleChange;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class Program {
    public int nonConstructableChange(int[] coins) {
        // Write your code here.
        int changeUpTo = 0;
        Arrays.sort(coins);
        for (int coin : coins) {
            if (coin > changeUpTo + 1) {
                return changeUpTo + 1;
            }
            changeUpTo += coin;
        }
        return changeUpTo + 1;
    }

    @Test
    public void TestCase1() {
        int[] input = new int[] {5, 7, 1, 1, 2, 3, 22};
        int expected = 20;
        int actual = new Program().nonConstructableChange(input);
        assertEquals(expected, actual);
    }
}
