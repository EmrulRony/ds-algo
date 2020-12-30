package leetcode.stack;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> greaterValueMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (Integer num : nums2){
            while (!stack.isEmpty() && num > stack.peek()){  //while is for arr like [8,7,6,5,10]
                greaterValueMap.put(stack.pop(),num);
            }
            stack.push(num);
        }

        for (int i=0; i< nums1.length; i++){
            nums1[i] = greaterValueMap.containsKey(nums1[i])?
                    greaterValueMap.get(nums1[i]) : -1;
        }
        return nums1;
    }

    @Test
    public void test(){
        int[] nums2 = {1,3,4,2};
        int[] nums1 = {4,1,2};
        int[] resultArr = nextGreaterElement(nums1, nums2);
        Arrays.stream(resultArr)
                .forEach(System.out::println);
    }
}
