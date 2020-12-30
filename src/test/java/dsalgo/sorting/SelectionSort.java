package dsalgo.sorting;

import org.junit.Test;

import java.util.Arrays;

public class SelectionSort {
    public int[] selectionSort(int[] numbers) {
        int minIndex = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[minIndex] > numbers[j]) {
                    minIndex = j;
                }
            }
            int temp = numbers[i];
            numbers[i] = numbers[minIndex];
            numbers[minIndex] = temp;
        }
        return numbers;
    }

    @Test
    public void test() {
        int[] numbers = {30, 10, 50, 20, 60, 40};
        int[] sortedNumbers = selectionSort(numbers);
        Arrays.stream(sortedNumbers)
                .forEach(System.out::println);
    }
}
