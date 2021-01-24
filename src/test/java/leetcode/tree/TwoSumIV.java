package leetcode.tree;

import leetcode.tree.node.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class TwoSumIV {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> hashTable = new HashSet<>();
        return preOrderTraverse(root,k,hashTable);
    }

    private boolean preOrderTraverse(TreeNode root, int k, Set<Integer> hashTable) {
        if (root == null) return false;
        int complement = k - root.val;
        if (hashTable.contains(complement)) return true;
        hashTable.add(root.val);
        return preOrderTraverse(root.left, k, hashTable) || preOrderTraverse(root.right, k, hashTable);
    }
}
