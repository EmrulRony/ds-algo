package algoexpert.binary_tree.node_depth;

import java.util.*;

class Program {

    public static int nodeDepths(BinaryTree root) {
        if (root != null) {
            return getNodeDepths(root, 0);
        }
        return -1;
    }

    private static int getNodeDepths(BinaryTree root, int depth) {
        if (root != null) {
            return depth + getNodeDepths(root.left , depth + 1) + getNodeDepths(root.right , depth + 1);
        }
        return 0;
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}
