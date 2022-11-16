package algoexpert.sorting.insertionSort;

public class Program {
    public static int[] insertionSort(int[] array) {
        // Write your code here.
        for (int i = 0; i < array.length; i++) {
            int currentVal = array[i];
            int arrIdx = i;
            while (arrIdx > 0 && array[arrIdx - 1] > currentVal) {
                array[arrIdx] = array[arrIdx - 1];
                arrIdx --;
            }
            array[arrIdx] = currentVal;
        }
        return array;
    }
}

