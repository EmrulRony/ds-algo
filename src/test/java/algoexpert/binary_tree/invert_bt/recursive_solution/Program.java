package algoexpert.binary_tree.invert_bt.recursive_solution;

import java.util.LinkedList;
import java.util.Queue;

public class Program {
    public static void invertBinaryTree(BinaryTree tree) {
        if (tree != null) {
            Queue<BinaryTree> queue = new LinkedList<>();
            queue.add(tree);
            while (!queue.isEmpty()) {
                BinaryTree currentNode = queue.remove();
                swapChilds(currentNode);
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }
    }

    private static void swapChilds(BinaryTree tree) {
        BinaryTree temp = tree.left;
        tree.left = tree.right;
        tree.right = temp;
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}