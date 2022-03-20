package algoexpert.twoNumberSum;

import java.util.Arrays;
import java.util.HashSet;

class Program {
    public static int[] twoNumberSum(int[] array, int targetSum) {
        // Write your code here.
        HashSet<Integer> hastTable = new HashSet<>();
        for (int x : array) {
            int y = targetSum - x;
            if (hastTable.contains(y)) {
                return new int[] {x, y};
            }
            hastTable.add(x);
        }
        return new int[] {};
    }
}


public class TwoNumberSum {
    public static void main(String[] args) {
        int[] result = Program.twoNumberSum(new int[]{3, 5, -4, 8, 11, 1, -1, 6}, 10);
        System.out.println(Arrays.toString(result));
    }
}
