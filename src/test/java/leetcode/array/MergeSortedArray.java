package leetcode.array;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mPointer = m - 1;
        int nPointer = n - 1;
        int changeIndex = nums1.length - 1;
        while (nPointer >= 0) {
            if (mPointer >= 0 && nums1[mPointer] >= nums2[nPointer]) {
                nums1[changeIndex] = nums1[mPointer];
                changeIndex--;
                mPointer--;
            } else {
                nums1[changeIndex] = nums2[nPointer];
                changeIndex--;
                nPointer--;
            }
        }
    }
}
