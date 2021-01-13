package leetcode.tree;

import leetcode.tree.node.TreeNode;

public class owestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < p.val){
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
