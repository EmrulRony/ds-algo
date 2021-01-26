package leetcode.tree;

import leetcode.tree.node.TreeNode;

public class FindSecondMinimumOnBT {
    int min1 = 0;
    long ans = Long.MAX_VALUE;
    public int findSecondMinimumValue(TreeNode root) {
        min1 = root.val;
        dfs(root);
        return ans < Long.MAX_VALUE? (int) ans: -1;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        else if (root.val == min1){
            dfs(root.left);
            dfs(root.right);
        }
        else if (root.val > min1 && root.val < ans){
            ans = root.val;
        }
    }
}
