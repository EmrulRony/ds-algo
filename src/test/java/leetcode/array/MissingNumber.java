package leetcode.array;

import java.util.HashSet;
import java.util.Set;

public class MissingNumber {

    public int missingNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 0; i <= nums.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }
    public int missingNumber(int[] nums) {
        int rangeSum = getSum(nums.length);
        int elementSum = 0;
        for (int num : nums) {
            elementSum += num;
        }
        return rangeSum - elementSum;
    }

    private int getSum(int length) {
        int total = 0;
        for (int i = 1; i <= length; i++) {
            total += i;
        }
        return total;
    }
}
