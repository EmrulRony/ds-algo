package leetcode;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> indexComplementMap = new HashMap<>();

        for (int i=0; i < nums.length; i++){
            int complement = target - nums[i];
            if (indexComplementMap.containsKey(nums[i])){
                return new int[]{i, indexComplementMap.get(nums[i])};
            } else {
                 indexComplementMap.put(complement,i);
            }
        }
        return new int[2];
    }

    @Test
    public void test(){
        int[] arr = {2,7,11,15};
        int[] res = twoSum(arr, 9);
        Arrays.stream(res)
                .forEach(System.out::println);
    }
}
