package algoexpert.binary_tree.node_depth.recursive_solution;

import java.util.Stack;

public class Program {

    public static int nodeDepths(BinaryTree root) {
        if (root != null) {
            int sumOfDepths = 0;
            Stack<Level> stack = new Stack<>();
            stack.push(new Level(root, 0));
            while (!stack.empty()) {
                Level topLevel = stack.pop();
                BinaryTree node = topLevel.binaryTree;
                int depth = topLevel.depth;
                sumOfDepths += depth;
                if (node.left != null) {
                    stack.push(new Level(node.left, depth + 1));
                }
                if (node.right != null) {
                    stack.push(new Level(node.right, depth + 1));
                }
            }
            return sumOfDepths;
        }
        return -1;
    }

    static class Level {
        BinaryTree binaryTree;
        int depth;

        public Level(BinaryTree binaryTree, int depth) {
            this.binaryTree = binaryTree;
            this.depth = depth;
        }
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
