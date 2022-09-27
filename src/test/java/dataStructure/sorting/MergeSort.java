package dataStructure.sorting;

import org.junit.Test;

import java.util.Arrays;

public class MergeSort {
    public int[] sort(int numbers[]) {
        int left = 0;
        int right = numbers.length - 1;
        mergeSort(numbers, left, right);
        return numbers;
    }

    public void mergeSort(int arr[], int left, int right) { // O(nLogN)
        if(left<right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid); // O(logN)
            mergeSort(arr, mid + 1, right); // // O(logN)
            merge(arr, mid, left, right);// O(n)
        }
    }

    public void merge(int[] arr, int mid, int left, int right) { // O(n)
        int[] leftSubArr = new int[mid - left + 1];
        int[] rightSubArr = new int[right - mid];
        // copying elements into left and right sub arr [O(n) + O(n) = O(n)]
        for (int i = 0; i < leftSubArr.length; i++) {
            leftSubArr[i] = arr[left + i];
        }
        for (int j = 0; j < rightSubArr.length; j++) {
            rightSubArr[j] = arr[mid + 1 + j];
        }

        // compare left and right sub array and insert the lowest at the right position
        int i = 0, j = 0, k = left;
        while (leftSubArr.length > i && rightSubArr.length > j) {
            if (leftSubArr[i] < rightSubArr[j]) {
                arr[k] = leftSubArr[i];
                i++;
            } else {
                arr[k] = rightSubArr[j];
                j++;
            }
            k++;
        }

        // append the remaining at the end of the resultant array
        while (i < leftSubArr.length) { // O(n)
            arr[k] = leftSubArr[i];
            i++;
            k++;
        }

        while (j < rightSubArr.length) { // O(n)
            arr[k] = rightSubArr[j];
            j++;
            k++;
        }
    }


    @Test
    public void testMergeSort() {
        int array[] = {10, 3, 2, 5, 8, 4, 3, 1, 2, 9, 7, 8};
        int[] sortedArray = sort(array);
        Arrays.stream(sortedArray)
                .forEach(e -> System.out.print(e + "  "));
    }
}
