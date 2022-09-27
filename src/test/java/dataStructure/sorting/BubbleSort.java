package dataStructure.sorting;

import org.junit.Test;

import java.util.Arrays;

public class BubbleSort {
    public int[] bubbleSort(int numbers[]){
        boolean isSorted = false;
        for(int i=0; i< numbers.length-1; i++){
            for (int j=0; j< numbers.length-1-i; j++){
                if(numbers[j]>numbers[j+1]){
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                    isSorted = true;
                }
                if(isSorted == false){
                    break;
                }
            }
        }
        return numbers;
    }

    @Test
    public void testBubbleSort(){
        int[] numbers = {30,10,50,20,60,40};
        int[] sortedArr = bubbleSort(numbers);

        Arrays.stream(sortedArr)
                .forEach(System.out::println);
    }
}
