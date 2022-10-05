package algoexpert.binarySearchTree.reconstructBst;

import java.util.ArrayList;

public class Program2 {
    // This is an input class. Do not edit.
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
        BST root = null;
        for (Integer value : preOrderTraversalValues) {
            root = reconstructBstInternal(root, value);
        }
        return root;
    }

    private BST reconstructBstInternal(BST root, Integer value) {
        if (root == null) {
            return new BST(value);
        }
        if (value < root.value) {
            if (root.left == null) {
                root.left = new BST(value);
            } else {
                root.left = reconstructBstInternal(root.left, value);
            }
        } else {
            if (root.right == null) {
                root.right = new BST(value);
            } else {
                root.right = reconstructBstInternal(root.right, value);
            }
        }
        return root;
    }
}
