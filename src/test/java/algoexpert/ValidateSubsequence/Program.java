package algoexpert.ValidateSubsequence;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class Program {
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        // Write your code here.
        int arrIndex = 0;
        int sequenceIndex = 0;
        while (arrIndex < array.size() && sequenceIndex < sequence.size()) {
            if (array.get(arrIndex).equals(sequence.get(sequenceIndex))) {
                sequenceIndex++;
            }
            arrIndex++;
        }
        return sequenceIndex == sequence.size();
    }

    @Test
    public void TestCase1() {
        var array = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10);
        var sequence = Arrays.asList(1, 6, -1, 10);
        assertTrue(Program.isValidSubsequence(array, sequence));
    }
}
