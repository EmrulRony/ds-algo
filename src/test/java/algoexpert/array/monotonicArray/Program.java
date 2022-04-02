package algoexpert.array.monotonicArray;

public class Program {
    // Sliding window technique
    public static boolean isMonotonic(int[] array) {
        // Write your code here.
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 0; i < array.length -1; i++) {
            if (array[i] > array[i+1]) {
                increasing = false;
            } else if (array[i] < array[i+1]) {
                decreasing = false;
            }
        }
        return increasing || decreasing;
    }
}
