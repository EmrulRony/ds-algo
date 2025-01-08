package leetcode.array;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        if (nums.length < 2) return;
        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            if (nums[left] == 0 && nums[right] != 0) {
                nums[left] = nums[right];
                nums[right] = 0;
                left++;
            } else if (nums[left] != 0 && nums[right] != 0) {
                left++;
            }
        }
    }
}
