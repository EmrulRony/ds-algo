package algoexpert.sorting;

public class Program {
    public static int[] bubbleSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        boolean isSorted = false;
        int count = 0;
        while (!isSorted) {
            isSorted = true;
            for (int j = 0; j < array.length - 1 - count; j++) {
                int f = j;
                int s = j + 1;
                if (array[f] > array[s]) {
                    int temp = array[s];
                    array[s] = array[f];
                    array[f] = temp;
                    isSorted = false;
                }
            }
            count++;
        }
        return array;
    }
}