package leetcode.array;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int majorityCount = nums.length / 2;
        for (int i = 0; i < nums.length -1; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count > majorityCount) {
                return i;
            }
        }
        return -1;
    }
}
