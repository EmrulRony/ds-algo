package leetcode.tree;

import leetcode.tree.node.TreeNode;

public class DiameterOfABinaryTree {
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return ans;
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);
        ans = Math.max(this.ans, Math.addExact(leftHeight,rightHeight)+1);
        return Math.max(leftHeight,rightHeight)+1;
    }
}
