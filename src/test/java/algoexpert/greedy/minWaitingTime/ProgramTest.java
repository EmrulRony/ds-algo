package algoexpert.greedy.minWaitingTime;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ProgramTest {
    @Test
    public void TestCase1() {
        int[] queries = new int[] {3, 2, 1, 2, 6};
        int expected = 17;
        var actual = new Program().minimumWaitingTime(queries);
        assertTrue(actual == expected);
    }
}
