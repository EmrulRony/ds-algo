package leetcode.linkedlist;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

public class RemoveDuplicate {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        for (int i=0; i<length-1; i++){
            if(nums[i] == nums[i+1]){
                for (int j=i+1; j<length-1;j++){
                    nums[j] = nums[j+1];
                }
                nums[length-1] = 0;
                length--;
            }
        }
        return length;
    }

    @Test
    public void test(){
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        int len = removeDuplicates(arr);
        IntStream.range(0,len)
                .forEach(index -> System.out.println(arr[index]));
    }
}
