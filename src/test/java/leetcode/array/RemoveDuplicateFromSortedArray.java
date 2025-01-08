package leetcode.array;

public class RemoveDuplicateFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int changeIndex = 1;
        int lastUniqueValue = nums[0];
        for (int i = 2; i < nums.length; i++) {
            if (lastUniqueValue != nums[i]) {
                nums[changeIndex] = nums[i];
                changeIndex = changeIndex + 1;
                lastUniqueValue = nums[i];
            }
        }
        return changeIndex;
    }
}
