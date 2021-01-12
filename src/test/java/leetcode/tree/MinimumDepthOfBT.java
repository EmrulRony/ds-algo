package leetcode.tree;

import leetcode.tree.node.TreeNode;

public class MinimumDepthOfBT {
    public int minDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        int depthOfLeft = minDepth(root.left);
        int depthOfRight = minDepth(root.right);
        if (depthOfLeft == 0 || depthOfRight == 0){
            return Math.max(depthOfLeft, depthOfRight) + 1;
        }
        return Math.min(depthOfLeft, depthOfRight)+1;
    }
}
