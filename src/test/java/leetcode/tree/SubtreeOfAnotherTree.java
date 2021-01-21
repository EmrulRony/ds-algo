package leetcode.tree;

import leetcode.tree.node.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s,t);
    }

    private boolean traverse(TreeNode s, TreeNode t) {
        return s!=null && (equals(s,t) || traverse(s.left,t) || traverse(s.right,t));
    }

    private boolean equals(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        else if (s == null || t == null) return false;
        return (s.val == t.val) && equals(s.left, t.left) && equals(s.right, t.right);
    }
}
