package leetcode.array;

import java.util.*;

public class IntersectionOfTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> result = new LinkedList<>();
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                result.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }


    // If the arrays are sorted
    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int left = 0;
        int right = 0;
        int insertIndex = 0;
        List<Integer> result = new LinkedList<>();
        while (left < nums1.length && right < nums2.length) {
            if (nums1[left] > nums2[right]) {
                right++;
            } else if (nums1[left] < nums2[right]) {
                left++;
            } else {
                result.add(nums1[left]);
                left++;
                right++;
            }
        }
        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();

    }
}
