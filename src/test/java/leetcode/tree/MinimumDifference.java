package leetcode.tree;

import leetcode.tree.node.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDifference {
    int minDiff = Integer.MAX_VALUE;
    TreeNode prevNode = null;
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return minDiff;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (prevNode != null){
            minDiff = Math.min(minDiff, Math.abs(root.val - prevNode.val));
        }
        prevNode = root;
        dfs(root.right);
    }
}
