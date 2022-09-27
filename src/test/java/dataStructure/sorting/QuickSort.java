package dataStructure.sorting;

import org.junit.Test;

import java.util.Arrays;

public class QuickSort {
    public int[] sort(int[] arr){
        int low = 0;
        int high = arr.length - 1;
        quickSort(arr,low,high);
        return arr;
    }

    public void quickSort(int arr[], int low, int high){
        if(low<high){
            int partitionIndex = partition(arr,low,high);
            quickSort(arr,low,partitionIndex-1);
            quickSort(arr,partitionIndex+1, high);
        }
    }

    public int partition(int[] arr, int low, int high){
        int pivot = high;
        int i = low -1;

        for (int j=low; j<=pivot; j++){
            if (arr[j] <= arr[pivot]){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        return i;
    }




    @Test
    public void testQuickSort(){
        int array[] = {10, 3, 2, 7, 7, 5, 8, 4, 1, 2, 9, 7, 8, 11};
        int[] sortedArray = sort(array);
        Arrays.stream(sortedArray)
                .forEach(e -> System.out.print(e + "   "));
    }
}

// the time complexity of quick sort is nLog(n)
