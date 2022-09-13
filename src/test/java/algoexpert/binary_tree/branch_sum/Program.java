package algoexpert.binary_tree.branch_sum;

import java.util.ArrayList;
import java.util.List;

class Program {
    // This is the class of the input root. Do not edit it.
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> branchSums(BinaryTree root) {
        List<Integer> sums = new ArrayList<>();
        findBranchSums(root, 0, sums);
        return sums;
    }

    private static void findBranchSums(BinaryTree root, int currentSum, List<Integer> sums) {
        if (root != null) {
            int newSum = currentSum + root.value;
            if (root.left == null && root.right == null) {
                sums.add(newSum);
            }
            findBranchSums(root.left, newSum, sums);
            findBranchSums(root.right, newSum, sums);
        }
    }
}
