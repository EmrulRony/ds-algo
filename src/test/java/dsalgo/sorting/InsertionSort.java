package dsalgo.sorting;

import org.junit.Test;

import java.util.Arrays;

public class InsertionSort {
    public int[] insertionSort(int[] numbers){
        for(int i=1; i<numbers.length; i++){
            int key = numbers[i];
            int j = i;
            while(j>0 && numbers[j-1]>key){
                numbers[j] = numbers[j-1];
                j--;
            }
            numbers[j] = key;
        }
        return numbers;
    }

    @Test
    public void test(){
        int arr[] = {10, 3, 2, 5, 8, 4, 3, 1, 2, 9, 7, 8};
        int[] resArr = insertionSort(arr);
        Arrays.stream(resArr)
                .forEach(e -> System.out.print(e + "  "));
    }
}

// {10, 3, 2, 5, 8, 4, 3, 1, 2, 9, 7, 8}
// after first iteration 3,10,2..
// second iteration steps
        // while loop iteration 1 -> 3,10,10..
        // while loop iteration 2 -> 10,3,10..
        // after second iteration --> 2, 3, 10....


