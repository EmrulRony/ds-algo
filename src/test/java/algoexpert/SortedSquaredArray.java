package algoexpert;

class Program {

    public int[] sortedSquaredArray(int[] array) {
        // Write your code here.
        int[] result = new int[array.length];
        int minValPointer = 0;
        int maxValPointer = array.length - 1;
        for (int i = maxValPointer; i >= 0; i--) {
            if (Math.abs(array[minValPointer]) > array[maxValPointer]) {
                result[i] = array[minValPointer] * array[minValPointer];
                minValPointer++;
            } else {
                result[i] = array[maxValPointer] * array[maxValPointer];
                maxValPointer--;
            }
        }
        return result;
    }
}

public class SortedSquaredArray {
    public static void main(String[] args) {

    }
}
