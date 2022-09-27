package dataStructure.searching;


import org.junit.Test;

public class Searching {
    // linear search
    // time complexity of linear search is O(n)
    public boolean linearSearch(int key, int[] numbers){
        boolean isFound = false;

        for (int i=0; i< numbers.length; i++){
            if (numbers[i] == key){
                isFound = true;
            }
        }
        return isFound;
    }

    // binary search
    // the items should be shorted
    // the time complexity of binary search is O(logn)
    public boolean binarySearch(int key, int[] numbers){
        boolean isFound = false;
        int left = 0;
        int right = numbers.length - 1;

        while (left <= right){
            int mid = left+right/2;
            if (numbers[mid] == key){
                isFound = true;
                break;
            } else if (numbers[mid] > key){
                right = mid - 1;
            } else if (numbers[mid] < key){
                left = mid + 1;
            }
        }
        return isFound;
    }

    @Test
    public void testLinear(){
        int numbers[] = {10,20,5,2,100,88,55,11,23,60};
        int key = 555;
        boolean result = linearSearch(key,numbers);
        System.out.println(result);
    }

    @Test
    public void testBinary(){
        int numbers[] = {3,4,5,6,7,8,9,10,11,12,12,14,15,16,17,18,19,20,21,22,23,24};
        int key = 15;
        boolean result = linearSearch(key,numbers);
        System.out.println(result);
    }
}
