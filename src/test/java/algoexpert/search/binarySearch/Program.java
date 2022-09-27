package algoexpert.search.binarySearch;

public class Program {
    public static int binarySearch(int[] array, int target) {
        if (array.length != 0) {
            int leftPointer = 0;
            int rightPointer = array.length - 1;
            while (rightPointer >= leftPointer) {
                int middle = (leftPointer + rightPointer) / 2;
                if (array[middle] == target) {
                    return middle;
                } else if (target < array[middle]) {
                    rightPointer = middle - 1;
                } else {
                    leftPointer = middle + 1;
                }
            }
        }
        return -1;
    }
}

