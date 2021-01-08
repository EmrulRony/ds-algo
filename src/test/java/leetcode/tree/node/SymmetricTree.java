package leetcode.tree.node;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        TreeNode p = root;
        TreeNode q = root;
        if (p == null && q == null){
            return true;
        }
        if (!checkEquality(p,q)){
            return false;
        }
        Queue<TreeNode> tree_p = new LinkedList<>();
        Queue<TreeNode> tree_q = new LinkedList<>();
        tree_p.add(p);
        tree_q.add(q);
        while (!tree_p.isEmpty() || !tree_q.isEmpty()) {
            TreeNode tempP = tree_p.poll();
            TreeNode tempQ = tree_q.poll();
            if (!checkEquality(tempP, tempQ)){
                return false;
            }
            if (tempP != null){
                tree_p.add(tempP.left);
                tree_p.add(tempP.right);
            }
            if (tempQ != null){
                tree_q.add(tempQ.left);
                tree_q.add(tempQ.right);
            }
        }
        if (tree_p.isEmpty() && tree_q.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkEquality(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        }
        return true;
    }
}
