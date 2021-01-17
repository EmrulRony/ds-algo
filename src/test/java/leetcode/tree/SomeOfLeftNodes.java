package leetcode.tree;

import leetcode.tree.node.TreeNode;

public class SomeOfLeftNodes {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root == null){
            return sum;
        }
        sum = dfs(root, sum);
        return sum;
    }

    private int dfs(TreeNode root, int sum) {
        if (root == null) return sum;
        if (root.left != null && (root.left.left == null && root.left.right == null)){
            sum += root.left.val;
        }
        sum = dfs(root.left,sum);
        sum = dfs(root.right,sum);
        return sum;
    }
}
