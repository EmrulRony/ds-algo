package leetcode.array;

import java.util.Arrays;
import java.util.Stack;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums); // O(nlogn)
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            if (!stack.isEmpty() && stack.peek().equals(num)) {
                stack.pop();
            } else {
                stack.push(num);
            }
        }
        return stack.peek();
    }
}
