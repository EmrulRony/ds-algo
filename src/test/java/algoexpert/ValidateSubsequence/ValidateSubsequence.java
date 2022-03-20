package algoexpert.ValidateSubsequence;

import java.util.Arrays;
import java.util.List;

class Program {
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
}

public class ValidateSubsequence {
    public static void main(String[] args) {
        boolean validSubsequence = Program.isValidSubsequence(Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10), Arrays.asList(1, 6, -1, -1));
        System.out.println(validSubsequence);
    }
}
