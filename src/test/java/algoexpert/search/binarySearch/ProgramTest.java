package algoexpert.search.binarySearch;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ProgramTest {
    @Test
    public void TestCase1() {
        assertTrue(
                Program.binarySearch(new int[] {0, 1, 21, 33, 45, 45, 61, 71, 72, 73}, 33) == 3);
    }
}
